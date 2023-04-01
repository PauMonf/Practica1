package es.uji.al415716;

import es.uji.al415716.Algorithm.CSV;
import es.uji.al415716.Algorithm.ExceptionKmeans;
import es.uji.al415716.Algorithm.KMeans;
import es.uji.al415716.Row.Row;
import es.uji.al415716.Row.RowWithLabel;
import es.uji.al415716.Table.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

class KMeansTest {

    @Test
    void train() {
    }

    @Test
    void estimate() throws Exception {
        CSV csv=new CSV();
        String sep = System.getProperty("file.separator");
        TableWithLabels table=csv.readTableWithLabel("data"+sep+"basic1.csv");
        KMeans kmeans=new KMeans(4,5,1);
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