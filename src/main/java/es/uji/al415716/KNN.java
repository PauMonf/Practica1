package es.uji.al415716;

import java.util.List;

public class KNN {
    private TableWithLabels table;

    public void train(TableWithLabels data) {
        table = data;
    }

    public Integer estimate(List<Double> data) throws Exception {
        int estimation = 0;
        double minDistance = -1;
        for (Object obj : table.getRows()) {
            RowWithLabel row = (RowWithLabel) obj;
            double aux = euclideanMetric(data, row.getData());
            if (aux < minDistance || minDistance==-1) {
                minDistance = aux;
                estimation = row.getNumberClass();
            }

            //Esto lo he puesto solo para optimizar, es prescindible
            if (minDistance == 0) break;
        }
        return estimation;
    }

    public double euclideanMetric(List<Double> z, List<Double> x) throws Exception {
        if (z.size() != x.size()) throw new Exception();
        double distance = 0;
        for (int i = 0; i < z.size(); i++) {
            distance += Math.pow(z.get(i) - x.get(i), 2);
        }
        return Math.sqrt(distance);
    }


}
