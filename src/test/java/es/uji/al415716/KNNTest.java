package es.uji.al415716;

import es.uji.al415716.Reader.CSV;
import es.uji.al415716.Algorithm.KNN;
import es.uji.al415716.Table.TableWithLabels;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {

    @Test
    void estimate() throws Exception {
        KNN knn = new KNN();
        CSV csv = new CSV();
        TableWithLabels tableWithLabels = csv.readTableWithLabel("data/iris.csv");
        knn.train(tableWithLabels);
        List<Double> data;

        //Test con valores de dentro de la tabla
        data=List.of(5.1,3.5,1.4,0.2);
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-setosa"), knn.estimate(data));
        data=List.of(6.3,2.5,4.9,1.5);
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-versicolor"), knn.estimate(data));
        data=List.of(5.9,3.0,5.1,1.8);
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-virginica"), knn.estimate(data));

        //Test con valores similares a los de la tabla
        data=List.of(5.1,3.5,1.4,0.0);
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-setosa"), knn.estimate(data));
        data=List.of(6.3,2.5,5.0,1.5);
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-versicolor"), knn.estimate(data));
        data=List.of(5.9,3.1,5.1,1.8);
        assertEquals(tableWithLabels.getLabelsToIndex().get("Iris-virginica"), knn.estimate(data));
    }


    @Test
    void euclideanMetric() throws Exception {
        KNN knn = new KNN();
        List<Double> a,b;

        a=List.of(0.0);
        b=List.of(1.0);
        assertEquals(1.0,knn.distance(a,b));
        a=List.of(0.0);
        b=List.of(-1.0);
        assertEquals(1.0,knn.distance(a,b));
        a=List.of(0.0,1.0);
        b=List.of(1.0,0.0);
        assertEquals(Math.sqrt(2),knn.distance(a,b));
        assertEquals(Math.sqrt(2),knn.distance(b,a));
        a=List.of(0.0,0.0,0.0);
        b=List.of(1.0,1.0,1.0);
        assertEquals(Math.sqrt(3),knn.distance(a,b));
        assertEquals(Math.sqrt(3),knn.distance(b,a));
        a=List.of(1.0,1.0,1.0,1.0);
        b=List.of(5.0,5.0,5.0,5.0);
        assertEquals(8.0,knn.distance(a,b));
        assertEquals(8.0,knn.distance(b,a));
    }
}