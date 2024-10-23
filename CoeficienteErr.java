import java.util.ArrayList;

public class CoeficienteErr {

    public static double CoefErrSIMPLE(ArrayList<Data> dataList,double b0,double b1){
        double error = 0;
        for (Data punto : dataList) {
            double prediccion = b0 + b1 *punto.getX();
            error += Math.pow(prediccion - punto.getY(), 2);
        }
        return error / dataList.size();
    }

    public static double CalcularR2SIMPLE(ArrayList<Data> Restante, double b0, double b1) {
        double SST = 0;
        double SSR = 0;
        double meanY = 0;

        // Calcular la media de Y
        for (Data p : Restante) {
            meanY += p.y;
        }
        meanY /= Restante.size();

        for (Data p : Restante) {
            // Total sum of squares
            SST += Math.pow(p.y - meanY, 2);
            // Residual sum of squares
            SSR += Math.pow(p.y - (b0 + b1 * p.x), 2);
        }

        // R^2 = 1 - (SS_res / SS_tot)
        return 1 - (SSR / SST);
    }

    public static double CoefErrCuadratico(ArrayList<Data> dataList,double b0,double b1,double b2){
        double error = 0;
        for (Data punto : dataList) {
            double prediccion = b0 + b1 * punto.getX() + b2 * Math.pow(punto.getX(), 2);
            error += Math.pow(prediccion - punto.getY(), 2);
        }
        return error / dataList.size();
    }

    public static double CalcularR2Cuadratico(ArrayList<Data> Restante, double b0, double b1, double b2) {
        double SST = 0;
        double SSR = 0;
        double meanY = 0;

        // Calcular la media de Y
        for (Data p : Restante) {
            meanY += p.y;
        }
        meanY /= Restante.size();

        for (Data p : Restante) {
            // Total sum of squares
            SST += Math.pow(p.y - meanY, 2);
            // Residual sum of squares
            SSR += Math.pow(p.y - (b0 + b1 * p.x + b2 * Math.pow(p.x, 2)), 2);
        }

        // R^2 = 1 - (SS_res / SS_tot)
        return 1 - (SSR / SST);
    }

    public static double CoefErrCubico(ArrayList<Data> dataList,double b0,double b1,double b2,double b3){
        double error = 0;
        for (Data punto : dataList) {
            double prediccion = b0 + b1 * punto.getX() + b2 * Math.pow(punto.getX(), 2) + b3 * Math.pow(punto.getX(), 3);
            error += Math.pow(prediccion - punto.getY(), 2);
        }
        return error / dataList.size();
    }

    public static double CalcularR2Cubico(ArrayList<Data> Restante, double b0, double b1, double b2, double b3) {
        double SST = 0;
        double SSR = 0;
        double meanY = 0;

        // Calcular la media de Y
        for (Data p : Restante) {
            meanY += p.y;
        }
        meanY /= Restante.size();

        for (Data p : Restante) {
            // Total sum of squares
            SST += Math.pow(p.y - meanY, 2);
            // Residual sum of squares
            SSR += Math.pow(p.y - (b0 + b1 * p.x + b2 * Math.pow(p.x, 2) + b3 * Math.pow(p.x, 3)), 2);
        }

        // R^2 = 1 - (SS_res / SS_tot)
        return 1 - (SSR / SST);
    }

}