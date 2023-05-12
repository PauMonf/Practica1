package es.uji.al415716.controlador;

import es.uji.al415716.modelo.Modelo;
import es.uji.al415716.modelo.algorithm.Algorithm;
import es.uji.al415716.modelo.algorithm.KMeans;
import es.uji.al415716.modelo.algorithm.KNN;
import es.uji.al415716.modelo.distance.Distance;
import es.uji.al415716.modelo.distance.EuclideanDistance;
import es.uji.al415716.modelo.distance.ManhattanDistance;
import es.uji.al415716.vista.Vista;

public class ImplementacionControlador implements Controlador{
    private Vista vista;
    private int algorithmNum;
    private int distanceNum;
    private String song;
    private Modelo modelo;
    private int numRecs;

    public ImplementacionControlador(){
        numRecs=5;
    }

    public void setVista(Vista vista){this.vista=vista;}

    public void setKNN(){ algorithmNum=0;}
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

    public void setNumRecs(int n){numRecs=n;}
    public int getNumRecs(){return numRecs;}

    public void setModelo(Modelo sr) {
        this.modelo = sr;
    }

    public void createModelo() throws Exception {
        Distance distance;
        switch (distanceNum){
            case 0: distance=new EuclideanDistance(); break;
            case 1: distance=new ManhattanDistance(); break;
            default: distance=new EuclideanDistance(); break;//valor predeterminado
        }
        modelo.setDistance(distance);

        Algorithm algorithm;
        switch (algorithmNum){
            case 0: algorithm=new KNN(distance); break;
            case 1: algorithm=new KMeans(15, 200, 4321, distance); break;
            default: algorithm=new KNN(distance); break;
        }
        modelo.setAlgorithm(algorithm);
    }

    public void runRecommend() throws Exception {
        modelo.recommend(song,numRecs);
        vista.updateRecs();
    }

    public void firstRecommend() throws Exception {
        createModelo();
        try {
            runRecommend();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        vista.creaGUIRecommend();
    }
}
