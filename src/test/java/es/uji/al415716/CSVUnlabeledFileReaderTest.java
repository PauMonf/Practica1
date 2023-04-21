package es.uji.al415716;

import es.uji.al415716.reader.CSVUnlabeledFileReader;
import es.uji.al415716.table.Table;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVUnlabeledFileReaderTest {

    @Test
    void readTableFromSource() throws FileNotFoundException {
        String sep = System.getProperty("file.separator");
        CSVUnlabeledFileReader csv = new CSVUnlabeledFileReader("data"+sep+"miles_dollars.csv");
        Table table = csv.readTableFromSource();

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
}