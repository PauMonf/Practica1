package es.uji.al415716.vista;

import es.uji.al415716.controlador.Controlador;
import es.uji.al415716.modelo.Modelo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Objects;

public class ImplementacionVista implements Vista{
    private final Stage stage;
    private Modelo modelo;
    private Controlador controlador;
    private Button recommendButton; //Lo he hecho global pq hay que actualizarlo
    private ObservableList<String> observableList;


    public ImplementacionVista(final Stage stage) {

        this.stage = stage;
    }

    public void setModelo(Modelo sr) {
        modelo = sr;
    }

    public void setControlador(Controlador c) {
        controlador = c;
    }

    public void creaGUI() {
        stage.setTitle("Song Recommender");
        VBox root = new VBox(5);

        Label labelBased = new Label("Recommend based on:");
        root.getChildren().add(labelBased);

        ToggleGroup basedOn = new ToggleGroup();
        RadioButton songFeatures = new RadioButton("Song features");
        songFeatures.setOnAction(actionEvent -> controlador.setKNN());
        songFeatures.fire(); //Esta linea es para poner elegir este botón como predeterminado
        songFeatures.setToggleGroup(basedOn);
        root.getChildren().add(songFeatures);
        RadioButton guessedGenere = new RadioButton("Guessed genere");
        guessedGenere.setOnAction(actionEvent -> controlador.setKMeans());
        guessedGenere.setToggleGroup(basedOn);
        root.getChildren().add(guessedGenere);

        Label labelDistance = new Label("\nDistance Type:");
        root.getChildren().add(labelDistance);

        ToggleGroup distance = new ToggleGroup();
        RadioButton euclideanButton = new RadioButton("Euclidean distance");
        euclideanButton.setOnAction(actionEvent -> controlador.setEuclidean());
        euclideanButton.fire();
        euclideanButton.setToggleGroup(distance);
        root.getChildren().add(euclideanButton);
        RadioButton manhattanButton = new RadioButton("Manhattan distance");
        manhattanButton.setOnAction(actionEvent -> controlador.setManhattan());
        manhattanButton.setToggleGroup(distance);
        root.getChildren().add(manhattanButton);

        Label labelSongTitles = new Label("\nSong Titles:");
        root.getChildren().add(labelSongTitles);

        ObservableList<String> observableList = FXCollections.observableList(modelo.getNames());
        ListView<String> songTitles = new ListView<>(observableList);
        songTitles.setOnMouseClicked(mouseEvent -> {
            controlador.setSong(songTitles.getSelectionModel().getSelectedItem());
            if (mouseEvent.getClickCount() > 1){ //En caso de doble click (o más)
                try {
                    controlador.firstRecommend();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        root.getChildren().add(songTitles);

        recommendButton = new Button("Recommend...");
        recommendButton.setDisable(true);
        recommendButton.setOnAction(actionEvent -> {
            try {
                controlador.firstRecommend();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        root.getChildren().add(recommendButton);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void creaGUIRecommend() {
        stage.setTitle("Recommended songs");
        VBox root = new VBox(5);

        HBox boxNumRecs=new HBox(3);
        Label labelNumRecs = new Label("Number of recommendations:");
        boxNumRecs.getChildren().add(labelNumRecs);

        Spinner<Integer> numRecsSpinner = new Spinner<>(1, modelo.getNames().size(), controlador.getNumRecs(), 1);
        numRecsSpinner.setEditable(true);
        numRecsSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!Objects.equals(controlador.getNumRecs(), newValue)) {
                controlador.setNumRecs(newValue);
                try {
                    controlador.runRecommend();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        boxNumRecs.getChildren().add(numRecsSpinner);
        root.getChildren().add(boxNumRecs);

        Label recommendationsTitle = new Label("If you liked " + controlador.getSong() + " you might like:");
        root.getChildren().add(recommendationsTitle);

        observableList = FXCollections.observableList(modelo.getRecommendations());
        ListView<String> recommendationsListView = new ListView<>(observableList);
        recommendationsListView.setOnMouseClicked(mouseEvent -> {
            controlador.setSong(recommendationsListView.getSelectionModel().getSelectedItem());
            try {
                controlador.runRecommend();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        root.getChildren().add(recommendationsListView);

        stage.setScene(new Scene(root, 210, 340));
        stage.show();
    }

    public void updateButton() {
        recommendButton.setText("Recommend on " + controlador.getSong());
        recommendButton.setDisable(false);
    }

    public void updateRecs() {
        if (observableList != null)
            observableList.setAll(modelo.getRecommendations());
        else
            observableList = FXCollections.observableList(modelo.getRecommendations());
    }

}
