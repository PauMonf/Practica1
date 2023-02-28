package es.uji.al415716;

import java.util.ArrayList;
import java.util.List;

public class Table <T extends Row>{
    private List<String> headers;
    private List<T> rows;

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

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Row getRowAt(int rowNummber) {
        return rows.get(rowNummber);
    }

    public boolean addRow(T row){
        return rows.add(row);
    }

}
