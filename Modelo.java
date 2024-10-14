public class Modelo {

    double b0, b1, b2;

    // Cambiamos el constructor para asignar los valores de los coeficientes
    public Modelo(double[] coefficients) {
        // Verificamos si los coeficientes tienen la longitud adecuada
        if (coefficients.length >= 3) {
            this.b0 = coefficients[0];
            this.b1 = coefficients[1];
            this.b2 = coefficients[2];
        }
    }

    public void MostrarModelo() {
        System.out.println("-------ECUACION-------");
        System.out.println("Y = B0 + (B1 * X1) + (B2 * X1^2)");
        System.out.println();
        System.out.println("-----Ecuacion Con valores sustituidos-----");
        System.out.println("Y = " + this.b0 + " (+) " + this.b1 + " * (X1) + " + this.b2 + " * x^2");
        System.out.println();
        // VALOR A SIMULAR
        double val = 4;
        System.out.println("-----La ecuacion con el valor " + val + " es-----");
        System.out.println(this.b0 + (this.b1 * val) + (this.b2 * val * val));
    }
}
