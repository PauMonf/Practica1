package es.uji.al415716;

import es.uji.al415716.Reader.CSV;
import es.uji.al415716.Algorithm.KMeans;
import es.uji.al415716.Table.TableWithLabels;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class KMeansTest {

    @Test
    void train() {
    }

    @Test
    void estimate() throws Exception {
        CSV csv = new CSV();
        String sep = System.getProperty("file.separator");
        TableWithLabels table = csv.readTableWithLabel("data" + sep + "basic1.csv");
        KMeans kmeans = new KMeans(4, 5, 1);
        kmeans.train(table);

        List<Double> a1 = List.of(96.5, 192.0);
        List<Double> a2 = List.of(112.5, 222.0);
        assertEquals(kmeans.estimate(a1), kmeans.estimate(a2));
        List<Double> b1 = List.of(250.0,125.0);
        List<Double> b2 = List.of(274.0,111.5);
        assertEquals(kmeans.estimate(b1), kmeans.estimate(b2));
        List<Double> c1 = List.of(360.0,360.0);
        List<Double> c2 = List.of(380.0,320.0);
        assertEquals(kmeans.estimate(c1), kmeans.estimate(c2));
        List<Double> d1 = List.of(500.0,180.0);
        List<Double> d2 = List.of(500.0,200.5);
        assertEquals(kmeans.estimate(d1), kmeans.estimate(d2));

        assertNotEquals(kmeans.estimate(a1), kmeans.estimate(b2));
        assertNotEquals(kmeans.estimate(b1), kmeans.estimate(c2));
        assertNotEquals(kmeans.estimate(c1), kmeans.estimate(d2));
    }
}