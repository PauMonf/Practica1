package es.uji.al415716.vista;

import es.uji.al415716.controlador.Controlador;
import es.uji.al415716.modelo.SongRecommender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Vista {
    private final Stage stage;
    private SongRecommender modelo;
    private Controlador controlador;
    public Vista(final Stage stage){
        this.stage=stage;
    }
    public void setModelo(SongRecommender sr){
        modelo=sr;
    }

    public void setControlador(Controlador c){
        controlador=c;
    }
    
    public void creaGUI(){
        stage.setTitle("Song Recommender");
        VBox root=new VBox();

        Label labelBased=new Label("Recommend based on:");
        root.getChildren().add(labelBased);

        ToggleGroup basedOn = new ToggleGroup();
        RadioButton songFeatures = new RadioButton("Song features");
        songFeatures.setOnAction(actionEvent -> controlador.setKNN());
        songFeatures.fire();
        songFeatures.setToggleGroup(basedOn);
        root.getChildren().add(songFeatures);
        RadioButton guessedGenere = new RadioButton("Guessed genere");
        guessedGenere.setOnAction(actionEvent -> controlador.setKMeans());
        guessedGenere.setToggleGroup(basedOn);
        root.getChildren().add(guessedGenere);

        Label labelDistance=new Label("\nDistance Type:");
        root.getChildren().add(labelDistance);

        ToggleGroup distance = new ToggleGroup();
        RadioButton euclidean = new RadioButton("Euclidean distance");
        euclidean.fire();
        euclidean.setToggleGroup(distance);
        root.getChildren().add(euclidean);
        RadioButton manhattan = new RadioButton("Manhattan distance");
        manhattan.setToggleGroup(distance);
        root.getChildren().add(manhattan);

        Label labelSongTitles = new Label("Song Titles:");
        root.getChildren().add(labelSongTitles);

        ObservableList<String> observableList= FXCollections.observableList(modelo.getNames());
        ListView<String> songTitles=new ListView<>(observableList);
        root.getChildren().add(songTitles);

        Button recommend = new Button("Recommend...");
        recommend.setDisable(true);
        root.getChildren().add(recommend);




        stage.setScene(new Scene(root, 210, 340));
        stage.show();
    }
}
