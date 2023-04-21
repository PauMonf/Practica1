package es.uji.al415716.algorithm;

import es.uji.al415716.distance.Distance;
import es.uji.al415716.distance.EuclideanDistance;
import es.uji.al415716.row.RowWithLabel;
import es.uji.al415716.table.TableWithLabels;

import java.util.List;

public class KNN implements Algorithm<TableWithLabels,List<Double>,Integer>, DistanceClient{
    private TableWithLabels table;
    private Distance distance;
    public KNN(){
        this.distance=new EuclideanDistance();
    }
    public KNN(Distance distance){
        this.distance=distance;
    }

    public void train(TableWithLabels data) {
        table = data;
    }

    public Integer estimate(List<Double> data){
        int estimation = 0;
        double minDistance = -1;
        for (Object obj : table.getRows()) {
            RowWithLabel row = (RowWithLabel) obj;
            double aux = distance(data, row.getData());
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

    public double distance(List<Double> z, List<Double> x){
        return distance.calculateDistance(z,x);
    }


    @Override
    public void setDistance(Distance distance) {
        this.distance=distance;
    }
}
