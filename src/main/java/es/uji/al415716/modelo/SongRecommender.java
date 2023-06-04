package es.uji.al415716.modelo;

import es.uji.al415716.modelo.algorithm.Algorithm;
import es.uji.al415716.modelo.algorithm.KMeans.UndefinedNameException;
import es.uji.al415716.modelo.algorithm.RecSys.RecSys;
import es.uji.al415716.modelo.distance.Distance;
import es.uji.al415716.modelo.reader.CSVLabeledFileReader;
import es.uji.al415716.modelo.table.TableWithLabels;
import es.uji.al415716.vista.Vista;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongRecommender implements Modelo{
    private TableWithLabels table;
    private TableWithLabels trainData;
    private List<String> names;
    private String sep = System.getProperty("file.separator");
    private String ruta = "data";
    private Distance distance;
    private RecSys recSys;
    private List<String> recommendations;
    private Vista vista;
    private String song;

    public SongRecommender() throws FileNotFoundException {
        CSVLabeledFileReader reader=new CSVLabeledFileReader(ruta+sep+"songs_test.csv");
        table=reader.readTableFromSource();
        names=readNames(ruta+sep+"songs_test_names.csv");
        reader=new CSVLabeledFileReader(ruta+sep+"songs_train.csv");
        trainData =reader.readTableFromSource();
    }

    public List<String> getNames() {
        return names;
    }

    public void setAlgorithm(Algorithm<TableWithLabels, List<Double>, Integer> algorithm,String song,int numRecs) throws Exception {
        /*
        Este método solo se ejecuta durante la primera recomendación (desde la primera GUI)
        y ahí es necesario ejecutar el run y el train, a partir de ahí solo utilizo el método
        runRecommend del controlador, que llama a recommend del modelo. No veo cómo se puede
        optimizar más.
        */
        recSys=new RecSys(algorithm);
        recSys.train(trainData);
        recSys.run(table,names);
        recommend(numRecs);
        vista.creaGUIRecommend();
    }

     public void setDistance(Distance distance){
        this.distance=distance;
     }

    private List<String> readNames(String fileOfItemNames) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileOfItemNames));
        List<String> names = new ArrayList<>();

        while (scanner.hasNextLine()) {
            names.add(scanner.nextLine());
        }
        scanner.close();
        return names;
    }

    public void recommend(int n) throws Exception {
        recommendations = recSys.recommend(song,n);
        vista.updateRecs();
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public void setSong(String song){
        this.song=song;
        vista.updateButton();
    }

    public int maxCluster(){
        try {
            int positionSong = names.indexOf(song);
            return recSys.getClassSet(positionSong).size();
        }catch (Exception e) {
            return getNames().size();
        }
    }
}
