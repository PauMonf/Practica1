package es.uji.al415716.reader;

import es.uji.al415716.table.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/*
* He creado este código porque estaba teniendo problemas con las diferencias entre Table y TableWithLabels (no acepataba
* el método addRowWithLabel, en el test no podia almacenar el resultado readTableFromSource en un TableWithLabels, ...).
* Así que he hecho una implementación de ReaderTemplate (esto) a la cual extienden tanto UnlabeledFileReader como LabeledFileReader.
* Además he cambiado la variable Table en ReaderTemplate por un genérico que extiende a Table.
* */

public class CSVFileReader<T extends Table> extends ReaderTemplate<T> {

    Scanner scanner;
    protected String SPLITTER=",";

    public CSVFileReader(String source) {
        super(source);
    }

    @Override
    void openSource(String source) throws FileNotFoundException {
        scanner = new Scanner(new File(source));
    }

    @Override
    void processHeaders(String headers) {
        table.setHeaders(lineToList(headers));
    }

    @Override
    void processData(String data) {    }

    @Override
    void closeSource() {
        scanner.close();
    }

    @Override
    boolean hasMoreData() {
        return scanner.hasNextLine();
    }

    @Override
    String getNextData() {
        return scanner.nextLine();
    }
    public List<String> lineToList(String line){
        return List.of(line.split(SPLITTER));
    }
}
