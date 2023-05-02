package es.uji.al415716.modelo;

import es.uji.al415716.modelo.reader.CSVLabeledFileReader;
import es.uji.al415716.modelo.table.TableWithLabels;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SongRecommender {
    private TableWithLabels table;
    private List<String> names;
    private String sep = System.getProperty("file.separator");
    private String ruta = "data";

    public List<String> getNames() {
        return names;
    }

    public SongRecommender() throws FileNotFoundException {
        CSVLabeledFileReader reader=new CSVLabeledFileReader(ruta+sep+"songs_test.csv");
        table=reader.readTableFromSource();
        names=readNames(ruta+sep+"songs_test_names.csv");
    }

    private List<String> readNames(String fileOfItemNames) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileOfItemNames));
        List<String> names = new ArrayList<>();

        while (scanner.hasNextLine()) {
            names.add(scanner.nextLine());
        }
        scanner.close();
        return names;
    }
}
