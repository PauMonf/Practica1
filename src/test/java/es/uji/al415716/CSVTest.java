package es.uji.al415716;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @Test
    void readTableWithLabels() throws FileNotFoundException {
        CSV csv = new CSV();
        TableWithLabels tableWithLabels=csv.readTableWithLabels("src/files/iris.csv");

        //Comrueba el número de ejemplares leído
        assertEquals(150,tableWithLabels.getRows().size());

        //Comprueba el número de columnas tres veces
        assertEquals(4,tableWithLabels.getRowAt(0).getData().size());
        assertEquals(4,tableWithLabels.getRowAt(70).getData().size());
        assertEquals(4,tableWithLabels.getRowAt(149).getData().size());

        //Comprueba si los nombres de las cabeceras son correctos
        List<String> stringsEsperados=List.of("sepal length","sepal width","petal length","petal width","class");
        assertEquals(stringsEsperados,tableWithLabels.getHeaders());

        //Comprueba el número asignado a cada fila
        RowWithLabel algo= (RowWithLabel) tableWithLabels.getRowAt(0);
        assertEquals(tableWithLabels.labelsToIndex.get("Iris-setosa"),algo.getNumberClass());
        algo= (RowWithLabel) tableWithLabels.getRowAt(70);
        assertEquals(tableWithLabels.labelsToIndex.get("Iris-versicolor"),algo.getNumberClass());
        algo= (RowWithLabel) tableWithLabels.getRowAt(149);
        assertEquals(tableWithLabels.labelsToIndex.get("Iris-virginica"),algo.getNumberClass());

        //Comprueba si la información guardada se corresponde con la del archivo
        List<Double> doublesEsperados=List.of(5.1,3.5,1.4,0.2);
        assertEquals(doublesEsperados,tableWithLabels.getRowAt(0).getData());
        doublesEsperados=List.of(5.9,3.2,4.8,1.8);
        assertEquals(doublesEsperados,tableWithLabels.getRowAt(70).getData());
        doublesEsperados=List.of(5.9,3.0,5.1,1.8);
        assertEquals(doublesEsperados,tableWithLabels.getRowAt(149).getData());
    }
}