import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Data> datos = Data.PR();  // Obtén los datos desde el método PR()
        Data.ObtenerDatos70();
        Data.ObtenerDatos30();
        Data.ObtenersegDatos30();
        Data.ObtenersegDatos70();

        int grado = 1;

        Modelo modelo = PolynomialR.PR(datos, grado);  // Pasa la lista de datos en lugar de la clase Data
        
        // Muestra el modelo (esto se puede agregar para verificar el resultado)
        modelo.MostrarModelo();
    }
}
