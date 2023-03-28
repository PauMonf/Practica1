package es.uji.al415716.Algorithm;

import es.uji.al415716.Row.RowWithLabel;
import es.uji.al415716.Table.TableWithLabels;

import java.util.List;

public class KNN implements Algorithm<TableWithLabels,List<Double>,Integer>{
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

            //Esto lo he puesto solo para optimizar pero es prescindible
            /*      Si la distancia es cero querrá decir que los datos estudiados coinciden con los de una fila
                de la tabla y que estos muy probablemente sean de la misma clase. Además de que hace el codigo
                ligeramente mas optimo al no consultar siempre todas las filas de la tabla.
            */
            if (minDistance == 0) break;
        }
        return estimation;
    }

    //Calcula la distancia entre dos puntos, si las dos listas no miden lo mismo lanzará un error.
    public double euclideanMetric(List<Double> z, List<Double> x) throws Exception {
        if (z.size() != x.size()) throw new Exception();
        double distance = 0;
        for (int i = 0; i < z.size(); i++) {
            distance += Math.pow(z.get(i) - x.get(i), 2);
        }
        return Math.sqrt(distance);
    }


}
