package es.uji.al415716;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table() {
        headers = new ArrayList<>();
        rows = new ArrayList<>();
    }

    public Table(int headersCapacity, int rowsCapacity) {
        headers = new ArrayList<>(headersCapacity);
        rows = new ArrayList<>(rowsCapacity);
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

    public boolean addRow(Row row){
        return rows.add(row);
    }

}
