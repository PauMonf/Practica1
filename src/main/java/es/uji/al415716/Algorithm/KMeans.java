package es.uji.al415716.Algorithm;

import es.uji.al415716.Row.Row;
import es.uji.al415716.Table.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans implements Algorithm<Table,List<Double>,Integer>{
    private int numClusters;
    private int numIterations;
    private long seed;
    private List<Cluster> clusters;

    public KMeans(int numClusters, int numIterations, long seed) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
        clusters=new ArrayList<>(numClusters);
    }

    public void train(Table datos) throws ExceptionKmeans {
        if(datos.getRows().size()<numClusters) throw new ExceptionKmeans();

        Random random = new Random(seed);

        //Guardo en clusters K puntos aleatorios de la tabla
        for (int i=0;i<numClusters;i++){
            int rnd=random.nextInt(datos.getRows().size());
            while (containsCluster(datos.getRowAt(rnd).getData()))
                rnd=random.nextInt(datos.getRows().size());
            clusters.add(new Cluster(i,datos.getRowAt(rnd).getData()));
        }

        int n;
        for(int i=0;i<numIterations;i++){
            for(Row row:datos.getRows()){
                n=closestCluster(row.getData());
                clusters.get(n).addRow(row);
            }
            actualizaCentroides();
            borraPuntos();
        }

    }
    private void actualizaCentroides(){
        for(Cluster cluster:clusters){
            cluster.centroide();
        }
    }
    private void borraPuntos(){
        for(Cluster cluster:clusters){
            cluster.borraRows();
        }
    }

    private int closestCluster(List<Double> dato){
        int n=0;
        double x=euclideanMetric(dato,clusters.get(0).getCentroide());
        double min=x;
        for(int j=1;j<clusters.size();j++){
            x=euclideanMetric(dato,clusters.get(j).getCentroide());
            if(x<min){
                min=x;
                n=j;
            }
        }
        return n;
    }

    public boolean containsCluster(List<Double> x){
        for(Cluster cluster:clusters){
            //Si da error haz que tenga en cuenta los null
            if(cluster.getCentroide().equals(x))
                return true;
        }
        return false;
    }

    public double euclideanMetric(List<Double> z, List<Double> x) {
        //if (z.size() != x.size()) throw new Exception();
        double distance = 0;
        for (int i = 0; i < z.size(); i++) {
            distance += Math.pow(z.get(i) - x.get(i), 2);
        }
        return Math.sqrt(distance);
    }

    public List<Double> centroide(List<Row> puntos) {
        List<Double> centroide = new ArrayList<>(puntos.get(0).getData().size());
        for (Row row : puntos) {
            for (int i = 0; i < row.getData().size(); i++)
                centroide.set(i, centroide.get(i) + row.getData().get(i));
        }
        for (int i = 0; i < centroide.size(); i++){
            centroide.set(i,centroide.get(i)/ puntos.size());
        }
        return centroide;
    }

    public Integer estimate(List<Double> dato){
        return closestCluster(dato);
    }


}
