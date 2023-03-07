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
        Kmeans kmeans=new Kmeans(3,2,1);
        CSV csv=new CSV();
        TableWithLabels table=csv.readTableWithLabels("src/files/basic1.csv");
        kmeans.train(table);
        int x= kmeans.estimate(List.of(245.55799410834155,134.50199833817595));
        System.out.println(x);
    }
}