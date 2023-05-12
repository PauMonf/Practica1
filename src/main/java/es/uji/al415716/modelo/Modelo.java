package es.uji.al415716.modelo;

import es.uji.al415716.modelo.algorithm.Algorithm;
import es.uji.al415716.modelo.algorithm.RecSys;
import es.uji.al415716.modelo.distance.Distance;
import es.uji.al415716.modelo.reader.CSVLabeledFileReader;
import es.uji.al415716.modelo.table.TableWithLabels;
import es.uji.al415716.vista.Vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Modelo {

    List<String> getNames();

    void setAlgorithm(Algorithm<TableWithLabels, List<Double>, Integer> algorithm) throws Exception;

    void setDistance(Distance distance);

    void recommend(String likdedItem,int n) throws Exception;

    List<String> getRecommendations() ;

    void setVista(Vista vista);
}
