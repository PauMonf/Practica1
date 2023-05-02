package es.uji.al415716.modelo.reader;

import es.uji.al415716.modelo.table.Table;

import java.io.FileNotFoundException;

public abstract class ReaderTemplate <T extends Table>{

    private String source;
    protected T table;

    public ReaderTemplate(String source) {
        this.source = source;
    }

    abstract void openSource(String source) throws FileNotFoundException;
    abstract void processHeaders(String headers);
    abstract void processData(String data);
    abstract void closeSource();
    abstract boolean hasMoreData(); // comprueba si hay más datos; en nuestro caso, si hay mas línea(s) en el fichero CSV
    abstract String getNextData(); // obtener el siguiente dato, una línea del fichero CSV en nuestro caso
    public final T readTableFromSource() throws FileNotFoundException {
        openSource(source);
        processHeaders(getNextData());
        while (hasMoreData()){
            processData(getNextData());
        }
        closeSource();
        return table;
    }


}
