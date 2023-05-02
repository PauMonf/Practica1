package es.uji.al415716;

import es.uji.al415716.modelo.reader.CSVLabeledFileReader;
import es.uji.al415716.modelo.table.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVLabeledFileReaderTest {

    @Test
    void readTableFromSource() throws FileNotFoundException {
        String sep = System.getProperty("file.separator");
        CSVLabeledFileReader csv = new CSVLabeledFileReader("data"+sep+"iris.csv");
        TableWithLabels tableWithLabels = csv.readTableFromSource();

        //Comrueba el número de ejemplares leído
        assertEquals(150, tableWithLabels.getRows().size());

        //Comprueba el número de columnas
        assertEquals(4, tableWithLabels.getRowAt(0).getData().size());
        assertEquals(4, tableWithLabels.getRowAt(70).getData().size());
        assertEquals(4, tableWithLabels.getRowAt(149).getData().size());

        //Comprueba si los nombres de las cabeceras son correctos
        List<String> stringsEsperados = List.of("sepal length", "sepal width", "petal length", "petal width", "class");
        assertEquals(stringsEsperados, tableWithLabels.getHeaders());

        //Comprueba el número asignado a cada fila
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-setosa"), tableWithLabels.getRowAt(0).getNumberClass());
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-versicolor"), tableWithLabels.getRowAt(70).getNumberClass());
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-virginica"), tableWithLabels.getRowAt(149).getNumberClass());

        //Comprueba si la información guardada se corresponde con la del archivo
        List<Double> doublesEsperados = List.of(5.1, 3.5, 1.4, 0.2);
        assertEquals(doublesEsperados, tableWithLabels.getRowAt(0).getData());
        doublesEsperados = List.of(5.9, 3.2, 4.8, 1.8);
        assertEquals(doublesEsperados, tableWithLabels.getRowAt(70).getData());
        doublesEsperados = List.of(5.9, 3.0, 5.1, 1.8);
        assertEquals(doublesEsperados, tableWithLabels.getRowAt(149).getData());
    }
}