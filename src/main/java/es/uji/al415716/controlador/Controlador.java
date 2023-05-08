package es.uji.al415716.controlador;

import es.uji.al415716.modelo.algorithm.Algorithm;
import es.uji.al415716.modelo.algorithm.KNN;
import es.uji.al415716.modelo.algorithm.RecSys;
import es.uji.al415716.vista.Vista;

import java.util.List;

public class Controlador {
    private Vista vista;
    private Algorithm algorithm;
    private int algorithmNum;
    private int distanceNum;
    private String song;

    public Controlador(){
    }

    public void setVista(Vista vista){this.vista=vista;}

    public void setKNN(){
        algorithmNum=0;
    }
    public void setKMeans(){
        algorithmNum=1;
    }

    public void setEuclidean(){ distanceNum=0;}
    public void setManhattan(){ distanceNum=1;}

    public void setSong(String song){
        this.song=song;
        vista.updateButton();
    }

    public String getSong() {
        return song;
    }

    public void runRecommend(){

    }
}
