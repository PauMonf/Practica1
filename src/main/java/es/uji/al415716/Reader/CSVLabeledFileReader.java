package es.uji.al415716.Reader;

import es.uji.al415716.Table.TableWithLabels;
import es.uji.al415716.Table.TableWithLabelsManager;

import java.util.List;

public class CSVLabeledFileReader extends CSVUnlabeledFileReader{
    public CSVLabeledFileReader(String source) {
        super(source);
        table=new TableWithLabels();
    }
    @Override
    void processData(String data) {
        String read = getNextData();
        int lastComa = read.lastIndexOf(SPLITTER);
        String stringClass = read.substring(lastComa + 1);
        List<String> list = lineToList(read.substring(0, lastComa));

        table.addRowWithLabel(list, stringClass);
    }

}
