package es.uji.al415716.Table;

import es.uji.al415716.Row.RowWithLabel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table {

    private Map<String, Integer> labelsToIndex;

    public TableWithLabels() {
        super();
        labelsToIndex = new HashMap<>();
    }

    public Map<String, Integer> getLabelsToIndex() {
        return labelsToIndex;
    }

    @Override
    public RowWithLabel getRowAt(int rowNummber) {
        return (RowWithLabel) super.getRowAt(rowNummber);
    }

    public void addRowWithLabel(List<String> data, String stringClass) {
        int numberClass;
        if (!labelsToIndex.containsKey(stringClass)) {
            numberClass = labelsToIndex.size();
            labelsToIndex.put(stringClass, numberClass);
        } else numberClass = labelsToIndex.get(stringClass);

        this.getRows().add(new RowWithLabel(data, numberClass));
    }
}
