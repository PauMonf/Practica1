package es.uji.al415716.Table;

import es.uji.al415716.Row.Row;

import java.util.List;

public interface TablesManager<T extends Table>{

    public void addRow(T table,String string);

}
