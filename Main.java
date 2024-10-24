import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Data.PR();
        Data.ObtenerDatos70();
        Data.ObtenerDatos30();
        Data.ObtenersegDatos30();
        Data.ObtenersegDatos70();

        int grado = 3;

        Modelo modelo = PolynomialR.PR(Data.Datos, grado);
        Modelo modelo2 = PolynomialR.PR(Data.datos70, grado);
        Modelo modelo3 = PolynomialR.PR(Data.segdatos30, grado);
        
        // Muestra el modelo (esto se puede agregar para verificar el resultado)
        modelo.MostrarModelo(modelo, modelo2, modelo3);
    }
}