package es.uji.al415716.Table;

import es.uji.al415716.Row.Row;
import es.uji.al415716.Row.RowWithLabel;

import java.util.List;

public class TableWithLabelsManager implements TablesManager<TableWithLabels>{

    @Override
    public void addRow(TableWithLabels table, String string) {
        int lastComa = string.lastIndexOf(",");
        String stringClass = string.substring(lastComa + 1);
        List<String> list = lineToList(string.substring(0, lastComa));

        table.addRowWithLabel(list, stringClass);
    }
    public List<String> lineToList(String line){
        return List.of(line.split(","));
    }
}

