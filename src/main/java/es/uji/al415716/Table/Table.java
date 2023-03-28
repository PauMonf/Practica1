package es.uji.al415716.Table;

import es.uji.al415716.Row.Row;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table() {
        headers = new ArrayList<>();
        rows = new ArrayList<>();
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public Row getRowAt(int rowNummber) {
        return rows.get(rowNummber);
    }

    public void addRow(List<String> data) {
        rows.add(new Row(data));
    }

}
