package es.uji.al415716.vista;

import es.uji.al415716.controlador.Controlador;
import es.uji.al415716.modelo.Modelo;

public interface Vista {
    void setModelo(Modelo sr);

    void setControlador(Controlador c);

    void creaGUI();

    void creaGUIRecommend();

    void updateButton();

    void updateRecs();
}
