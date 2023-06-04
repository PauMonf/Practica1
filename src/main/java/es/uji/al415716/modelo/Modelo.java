package es.uji.al415716.modelo;

import es.uji.al415716.modelo.algorithm.Algorithm;
import es.uji.al415716.modelo.distance.Distance;
import es.uji.al415716.modelo.table.TableWithLabels;
import es.uji.al415716.vista.Vista;

import java.util.List;

public interface Modelo {

    List<String> getNames();

    void setAlgorithm(Algorithm<TableWithLabels, List<Double>, Integer> algorithm,String song,int numRecs) throws Exception;

    void setDistance(Distance distance);

    void recommend(int n) throws Exception;

    List<String> getRecommendations() ;

    void setVista(Vista vista);

    void setSong(String song);

    int maxCluster();
}
