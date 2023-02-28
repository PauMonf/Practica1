package es.uji.al415716;

import java.util.List;

public class RowWithLabel extends Row {
    private int numberClass;

    private RowWithLabel() {
        numberClass = 0;
    }

    public RowWithLabel(List<String> data, int numberClass) {
        this.setData(stringListToDouble(data));
        this.numberClass = numberClass;
    }

    public int getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }
}
