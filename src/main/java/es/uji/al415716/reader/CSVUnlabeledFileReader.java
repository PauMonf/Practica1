package es.uji.al415716.reader;

import es.uji.al415716.table.Table;

public class CSVUnlabeledFileReader extends CSVFileReader<Table> {
    public CSVUnlabeledFileReader(String source) {
        super(source);
        table=new Table();
    }

    @Override
    void processData(String data) {
        table.addRow(lineToList(data));
    }
}
