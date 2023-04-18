package es.uji.al415716.Reader;

import es.uji.al415716.Table.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CSVUnlabeledFileReader extends ReaderTemplate{
    Scanner scanner;

    protected String SPLITTER=",";

    public CSVUnlabeledFileReader(String source) {
        super(source);
        table=new Table();
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
    void processData(String data) {
        table.addRow(lineToList(data));
    }

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
