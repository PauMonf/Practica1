package es.uji.al415716.modelo.reader;

import es.uji.al415716.modelo.table.TableWithLabels;

import java.util.List;

public class CSVLabeledFileReader extends CSVFileReader<TableWithLabels> {

    public CSVLabeledFileReader(String source) {
        super(source);
        table=new TableWithLabels();
    }
    @Override
    void processData(String data) {
        int lastComa = data.lastIndexOf(SPLITTER);
        String stringClass = data.substring(lastComa + 1);
        List<String> list = lineToList(data.substring(0, lastComa));

        table.addRowWithLabel(list,stringClass);
    }


}
