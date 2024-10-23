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
        if (coefficients.length >= 4) this.b3 = coefficients[3];  // Para el modelo cúbico
    }

    public void MostrarModelo( ) {
        if (grado == 1) {
            System.out.println("-------Regresión lineal-------");
            System.out.println("-------ECUACION-------");
            System.out.println("Y = B0 + (B1 * X1)");
            System.out.println();
            System.out.println("-----Ecuacion Con valores sustituidos-----");
            System.out.println("Y = " + this.b0 + " (+) " + this.b1 + " * (X1)");
            System.out.println();
            System.out.println("Coeficiente de error:" );
            double val = 4;
            System.out.println("-----La ecuacion con el valor " + val + " es-----");
            System.out.println(this.b0 + (this.b1 * val));
        } else if (grado == 2) {
            System.out.println("-------Regresión cuadrática-------");
            System.out.println("-------ECUACION-------");
            System.out.println("Y = B0 + (B1 * X1) + (B2 * X1^2)");
            System.out.println();
            System.out.println("-----Ecuacion Con valores sustituidos-----");
            System.out.println("Y = " + this.b0 + " (+) " + this.b1 + " * (X1) + " + this.b2 + " * X1^2");
            System.out.println();
            double val = 4;
            System.out.println("-----La ecuacion con el valor " + val + " es-----");
            System.out.println(this.b0 + (this.b1 * val) + (this.b2 * val * val));
        } else if (grado == 3) {
            
            System.out.println("-------Regresión cúbica-------");
            System.out.println("-------ECUACION-------");
            System.out.println("Y = B0 + (B1 * X1) + (B2 * X1^2) + (B3 * X1^3)");
            System.out.println();
            System.out.println("-----Ecuacion Con valores sustituidos-----");
            System.out.println("Y = " + this.b0 + " + " +"("+ this.b1 + " * X1) + " +"("+ this.b2 + " * X1^2) + " + "("+this.b3 + " * X1^3)");
            System.out.println();
            double val = 4;
            System.out.println("-----La ecuacion con el valor " + val + " es-----");
            System.out.println(this.b0 + (this.b1 * val) + (this.b2 * val * val) + (this.b3 * val * val * val));
        }
    }
}
