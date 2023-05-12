package es.uji.al415716.controlador;

import es.uji.al415716.modelo.Modelo;
import es.uji.al415716.vista.Vista;

public interface Controlador {
    void setVista(Vista vista);

    void setKNN();

    void setKMeans();

    void setEuclidean();

    void setManhattan();

    void setSong(String song);

    String getSong();

    void setNumRecs(int n);

    int getNumRecs();

    void setModelo(Modelo sr);

    void createModelo() throws Exception;

    void runRecommend() throws Exception;

    void firstRecommend() throws Exception;
}
