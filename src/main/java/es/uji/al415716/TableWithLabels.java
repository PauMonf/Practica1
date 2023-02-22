package es.uji.al415716;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{

    public Map<String,Integer> labelsToIndex;

    public TableWithLabels(){
        this.setHeaders(new ArrayList<>());
        this.setRows(new ArrayList<>());
        labelsToIndex=new HashMap<>();
    }

}