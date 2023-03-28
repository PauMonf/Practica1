package es.uji.al415716;

import es.uji.al415716.Algorithm.CSV;
import es.uji.al415716.Table.Table;
import es.uji.al415716.Table.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    @Test
    void readTable() throws FileNotFoundException {
        CSV csv = new CSV();
        Table table = csv.readTable("data/miles_dollars.csv");

        //Comrueba el número de ejemplares leído
        assertEquals(25, table.getRows().size());

        //Comprueba el número de columnas
        assertEquals(2, table.getRowAt(0).getData().size());
        assertEquals(2, table.getRowAt(12).getData().size());
        assertEquals(2, table.getRowAt(24).getData().size());

        //Comprueba si los nombres de las cabeceras son correctos
        List<String> stringsEsperados = List.of("Miles","Dollars");
        assertEquals(stringsEsperados, table.getHeaders());

        //Comprueba si la información guardada se corresponde con la del archivo
        List<Double> doublesEsperados = List.of(1211.0, 1802.0);
        assertEquals(doublesEsperados, table.getRowAt(0).getData());
        doublesEsperados = List.of(3082.0,3555.0);
        assertEquals(doublesEsperados, table.getRowAt(12).getData());
        doublesEsperados = List.of(5439.0,6964.0);
        assertEquals(doublesEsperados, table.getRowAt(24).getData());
    }

    @Test
    void readTableWithLabels() throws FileNotFoundException {
        CSV csv = new CSV();
        TableWithLabels tableWithLabels = csv.readTableWithLabel("data/iris.csv");

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