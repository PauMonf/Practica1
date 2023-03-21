package es.uji.al415716;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KmeansTest {

    @Test
    void train() {
    }

    @Test
    void estimate() throws FileNotFoundException {
        CSV csv=new CSV();
        TableWithLabels table=csv.readTableWithLabels("src/files/basic1.csv");
        Kmeans kmeans=new Kmeans(4,5,1);
        kmeans.train(table);
        int x= kmeans.estimate(List.of(79.40828883263248,152.8344238267352));
        System.out.println("Resultado: "+x+" Esperado: 0");
        x= kmeans.estimate(List.of(262.35201641365506,64.57463208572932));
        System.out.println("Resultado: "+x+" Esperado: 1");

        int y;
        RowWithLabel rowWithLabel;
        for(Row row:table.getRows()){
            x=kmeans.estimate(row.getData());
            rowWithLabel=(RowWithLabel) row;
            y=rowWithLabel.getNumberClass();
            System.out.println("Resultado: "+x+" Esperado: "+y);
        }
    }
}