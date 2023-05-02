package es.uji.al415716.controlador;

import es.uji.al415716.modelo.algorithm.Algorithm;
import es.uji.al415716.modelo.algorithm.KNN;
import es.uji.al415716.modelo.algorithm.RecSys;

import java.util.List;

public class Controlador {
    private Algorithm algorithm;
    private String algorithmName;
    public Controlador(){
    }

    public void setKNN(){
        algorithmName="KNN";
    }
    public void setKMeans(){
        algorithmName="kMeans";
    }
}
