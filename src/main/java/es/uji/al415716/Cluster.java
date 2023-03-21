package es.uji.al415716;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cluster {
    private int nCluster;
    private Set<Row> rows;
    private List<Double> centroide;

    public Cluster(){
        nCluster=0;
        rows=new HashSet<>();
        centroide=new ArrayList<>();
    }

    public Cluster(int nCluster,List<Double> centroide){
        this.nCluster=nCluster;
        this.centroide=centroide;
        rows=new HashSet<>();
    }

    public int getnCluster() {
        return nCluster;
    }

    public Set<Row> getRows() {
        return rows;
    }

    public List<Double> getCentroide() {
        return centroide;
    }

    public void addRow(Row row){
        rows.add(row);
    }

    public void centroide() {
        List<Double> calculo = new ArrayList<>(centroide.size());
        for(int i=0;i<centroide.size();i++)
            calculo.add(0.0);
        for (Row row : rows) {
            for (int i = 0; i < row.getData().size(); i++)
                calculo.set(i, calculo.get(i) + row.getData().get(i));
        }
        for (int i = 0; i < calculo.size(); i++){
            calculo.set(i,calculo.get(i)/ rows.size());
        }
        centroide=calculo;
    }

    public void borraRows(){
        rows.clear();
    }
}
