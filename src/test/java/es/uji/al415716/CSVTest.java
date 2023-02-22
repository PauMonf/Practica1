package es.uji.al415716;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @org.junit.jupiter.api.Test
    void readTableWithLabels() throws FileNotFoundException {
        CSV csv = new CSV();
        TableWithLabels tableWithLabels=csv.readTableWithLabels("src/files/iris.csv");
        //Comrueba el número de ejemplares leído
        assertEquals(150,tableWithLabels.getRows().size());
        //Comprueba el número de columnas tres veces
        assertEquals(4,tableWithLabels.getRowAt(0).getData().size());
        assertEquals(4,tableWithLabels.getRowAt(70).getData().size());
        assertEquals(4,tableWithLabels.getRowAt(149).getData().size());
        //Comprueba si el nombre de las etiquetas de las cabeceras es correcto
    }
}