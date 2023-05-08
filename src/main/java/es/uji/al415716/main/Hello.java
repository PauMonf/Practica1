package es.uji.al415716.main;

import es.uji.al415716.controlador.Controlador;
import es.uji.al415716.modelo.SongRecommender;
import es.uji.al415716.vista.Vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Hello extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage primaryStage) throws FileNotFoundException {
        Vista vista=new Vista(primaryStage);

        primaryStage.setTitle("Hello World!");
        StackPane root = new StackPane();
        Button btn = new Button("Hola");
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 250, 130));

        SongRecommender sr=new SongRecommender();
        Controlador controlador=new Controlador();
        vista.setModelo(sr);
        vista.setControlador(controlador);
        controlador.setVista(vista);

        vista.creaGUI();

        primaryStage.show();
    }
}
