import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Data.PR();
        Data.ObtenerDatos70();
        Data.ObtenerDatos30();
        Data.ObtenersegDatos30();
        Data.ObtenersegDatos70();

        int grado = 1;

        Modelo modelo = PolynomialR.PR(Data.datos70, grado);  // Pasa la lista de datos en lugar de la clase Data
        Modelo modelo2 = PolynomialR.PR(Data.segdatos30, grado);
        
        // Muestra el modelo (esto se puede agregar para verificar el resultado)
        modelo.MostrarModelo(modelo, modelo2);
    }
}