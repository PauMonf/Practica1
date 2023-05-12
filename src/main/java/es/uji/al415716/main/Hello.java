package es.uji.al415716.main;

import es.uji.al415716.controlador.Controlador;
import es.uji.al415716.controlador.ImplementacionControlador;
import es.uji.al415716.modelo.Modelo;
import es.uji.al415716.modelo.SongRecommender;
import es.uji.al415716.vista.ImplementacionVista;
import es.uji.al415716.vista.Vista;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Hello extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage primaryStage) throws FileNotFoundException {
        Vista vista=new ImplementacionVista(primaryStage);
        Modelo modelo=new SongRecommender();
        Controlador controlador=new ImplementacionControlador();
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        modelo.setVista(vista);

        vista.creaGUI();

        primaryStage.show();
    }
}
