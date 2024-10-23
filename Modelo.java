import java.util.ArrayList;

public class Modelo {

    double b0, b1, b2, b3;  // Añadí b3 para un posible modelo cúbico
    int grado;

    // Cambiamos el constructor para asignar los valores de los coeficientes y el grado
    public Modelo(double[] coefficients) {
        this.grado = coefficients.length - 1;
        
        // Asignar coeficientes dependiendo del grado
        if (coefficients.length >= 1) this.b0 = coefficients[0];
        if (coefficients.length >= 2) this.b1 = coefficients[1];
        if (coefficients.length >= 3) this.b2 = coefficients[2];
        if (coefficients.length >= 4) this.b3 = coefficients[3];  
    }

    public void MostrarModelo(Modelo modelo, Modelo modelo2) {
        if (grado == 1) {
            
            System.out.println("--------------<Regresión lineal>--------------");
            System.out.println("             70% - 30% de los datos           ");  
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("ECUACION: Y = B0 + (B1 * X1)");
            System.out.println();
            System.out.println("Y = " + modelo.b0 + " (+) " + modelo.b1 + " * (X1)");
            System.out.println();
            System.out.println("R2:" + CoeficienteErr.CalcularR2SIMPLE(Data.datos30, modelo.b0, modelo.b1));
            System.out.println("----------------------------------------------");
            System.out.println("                  Simulaciones                ");
            System.out.println("----------------------------------------------");
            int []val = {100, 102, 104, 95, 109};
            for(int valores: val){
                double y = modelo.b0 + (modelo.b1 * valores);
                System.out.println("X: " + valores + "  Y = " + y);
            }
            //SEGUNDA SEGMENTACION
            System.out.println("----------------------------------------------");
            System.out.println("             30% - 70% de los datos           ");  
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("ECUACION: Y = B0 + (B1 * X1)");
            System.out.println();
            System.out.println("Y = " + modelo2.b0 + " (+) " + modelo2.b1 + " * (X1)");
            System.out.println();
            System.out.println("R2:" + CoeficienteErr.CalcularR2SIMPLE(Data.segdatos70, modelo2.b0, modelo2.b1));
            System.out.println("----------------------------------------------");
            System.out.println("                  Simulaciones                ");
            System.out.println("----------------------------------------------");
            int []val2 = {100, 102, 104, 95, 109};
            for(int valores: val2){
                double y = modelo2.b0 + (modelo2.b1 * valores);
                System.out.println("X: " + valores + "  Y = " + y);
            }

        } else if (grado == 2) {
            System.out.println("------------<Regresión cuadrática>------------");
            System.out.println("             70% - 30% de los datos           ");  
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("ECUACION: Y = B0 + (B1 * X1) + (B2 * X1^2)");
            System.out.println();
            System.out.println("-----Ecuacion Con valores sustituidos-----");
            System.out.println("Y = " + modelo.b0 + " (+) " + modelo.b1 + " * (X1) + " + modelo.b2 + " * X1^2");
            System.out.println();
            System.out.println("R2:" + CoeficienteErr.CalcularR2Cuadratico(Data.datos30, modelo.b0, modelo.b1, modelo.b2));
            System.out.println("----------------------------------------------");
            System.out.println("                  Simulaciones                ");
            System.out.println("----------------------------------------------");
            double val[] = {4, 5, 6, 7, 8};
                for (double x : val) {
                double result = b0 * (x * x) + b1 * x + b2;  
                System.out.println("X:" + x + " Y = " + result);
            }
            //SEGUNDA SEGMENTACION
            System.out.println("----------------------------------------------");
            System.out.println("             30% - 70% de los datos           ");  
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("ECUACION: Y = B0 + (B1 * X1) + (B2 * X1^2)");
            System.out.println();
            System.out.println("Y = " + modelo2.b0 + " (+) " + modelo2.b1 + " * (X1) + " + modelo2.b2 + " * X1^2");
            System.out.println();
            System.out.println("R2:" + CoeficienteErr.CalcularR2Cuadratico(Data.segdatos70, modelo2.b0, modelo2.b1, modelo2.b2));
            System.out.println("----------------------------------------------");
            System.out.println("                  Simulaciones                ");
            System.out.println("----------------------------------------------");
            double val2[] = {4, 5, 6, 7, 8};
                for (double x : val2) {
                double result = b0 * (x * x) + b1 * x + b2;  
                System.out.println("X:" + x + " Y = " + result);
            }

        } else if (grado == 3) {
            System.out.println("--------------<Regresión cúbica>--------------");
            System.out.println("             70% - 30% de los datos           ");  
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("ECUACION: Y = B0 + (B1 * X1) + (B2 * X1^2) + (B3 * X1^3)");
            System.out.println();
            System.out.println("Y = " + modelo.b0 + " + " +"("+ modelo.b1 + " * X1) + " +"("+ modelo.b2 + " * X1^2) + " + "("+modelo.b3 + " * X1^3)");
            System.out.println();
            System.out.println("R2:" + CoeficienteErr.CalcularR2Cubico(Data.datos30, modelo.b0, modelo.b1, modelo.b2, modelo.b3));
            //SEGUNDA SEGMENTACION
            System.out.println("----------------------------------------------");
            System.out.println("             30% - 70% de los datos           ");  
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("ECUACION: Y = B0 + (B1 * X1) + (B2 * X1^2) + (B3 * X1^3)");
            System.out.println();
            System.out.println("Y = " + modelo2.b0 + " + " +"("+ modelo2.b1 + " * X1) + " +"("+ modelo2.b2 + " * X1^2) + " + "("+modelo2.b3 + " * X1^3)");
            System.out.println();
            System.out.println("R2:" + CoeficienteErr.CalcularR2Cubico(Data.segdatos70, modelo2.b0, modelo2.b1, modelo2.b2, modelo2.b3));
            
            
        }
    }
}