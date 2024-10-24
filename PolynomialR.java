import java.util.ArrayList;

public class PolynomialR {
    public static Modelo PR(ArrayList<Data> datosList, int grado) {
        
        double[] sumasX = new double[2 * grado + 1];
        double[] sumasXY = new double[grado + 1];

        // Calcular sumas de potencias de x y x*y
        for (Data datos : datosList) {
            double xt = datos.getX();
            double y = datos.getY();

            // Sumas de potencias de x
            double xtPot = 1;  
            for (int i = 0; i <= 2 * grado; i++) {
                sumasX[i] += xtPot;
                if (i <= grado) {
                    sumasXY[i] += xtPot * y;
                }
                xtPot *= xt;  // Incrementar la potencia de xt
            }
        }

        // Crear la matriz X y el vector Y de acuerdo al grado
        double[][] matrizx = new double[grado + 1][grado + 1];
        double[][] matrizy = new double[grado + 1][1];

        // Llenar la matriz X (sumas de potencias de x)
        for (int i = 0; i <= grado; i++) {
            for (int j = 0; j <= grado; j++) {
                matrizx[i][j] = sumasX[i + j];
            }
            matrizy[i][0] = sumasXY[i];
        }

        int filas = matrizx.length;
        int columnas = matrizx[0].length;

        // CALCULAR TRANSPUESTA
        double[][] Transpuesta = new double[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < matrizx[0].length; j++) {
                Transpuesta[j][i] = matrizx[i][j];
            }
        }

        // CALCULAR MATRIZ X TRANSPUESTA
        double[][] matrizXTrans = new double[columnas][filas];
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int z = 0; z < filas; z++) {
                    matrizXTrans[i][j] += Transpuesta[i][z] * matrizx[z][j];
                }
            }
        }

        // CALCULAR INVERSA
        double[][] matrizIdentidad = new double[columnas][columnas];
        for (int i = 0; i < columnas; i++) {
            matrizIdentidad[i][i] = 1.0;
        }
        double[][] matrizCompleta = new double[columnas][2 * columnas];
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizCompleta[i][j] = matrizXTrans[i][j];
                matrizCompleta[i][j + columnas] = matrizIdentidad[i][j];
            }
        }
        for (int i = 0; i < matrizCompleta.length; i++) {
            double carry = matrizCompleta[i][i];
            for (int j = 0; j < matrizCompleta.length * 2; j++) {
                matrizCompleta[i][j] /= carry;
            }
            for (int z = 0; z < matrizCompleta.length; z++) {
                if (z != i) {
                    double factSolt = matrizCompleta[z][i];
                    for (int j = 0; j < matrizCompleta.length * 2; j++) {
                        matrizCompleta[z][j] -= factSolt * matrizCompleta[i][j];
                    }
                }
            }
        }

        double[][] parteDerecha = new double[matrizCompleta.length][matrizCompleta[0].length / 2];
        for (int i = 0; i < matrizCompleta.length; i++) {
            for (int j = 0; j < matrizCompleta.length; j++) {
                parteDerecha[i][j] = matrizCompleta[i][j + matrizCompleta[0].length / 2];
            }
        }

        // CALCULAR TRANSPUESTA DE X * Y
        double[][] transxXy = new double[Transpuesta.length][matrizy.length];
        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < Transpuesta[0].length; j++) {
                double resultado = 0;
                for (int k = 0; k < matrizy.length; k++) {
                    resultado += Transpuesta[i][k] * matrizy[k][0];
                }
                transxXy[i][j] = resultado;
            }
        }

        // CALCULAR (X^T * X)^-1 * X^T * Y
        double[] total = new double[parteDerecha.length];
        for (int i = 0; i < parteDerecha.length; i++) {
            double resultado = 0;
            for (int k = 0; k < parteDerecha[0].length; k++) {
                resultado += parteDerecha[i][k] * transxXy[k][0];
            }
            total[i] = resultado;
        }

        return new Modelo(total);
    }
}
