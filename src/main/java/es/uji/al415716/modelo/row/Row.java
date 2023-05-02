package es.uji.al415716.modelo.row;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> data;

    public Row() {
        data = new ArrayList<>();
    }

    public Row(List<String> data) {
        this.data = stringListToDouble(data);
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    //Le pasas una lista de Strings y los transforma en Doubles
    public List<Double> stringListToDouble(List<String> data) {
        List<Double> doubleList = new ArrayList<>(data.size());
        for (String string : data) {
            doubleList.add(Double.valueOf(string));
        }
        return doubleList;
    }
}
