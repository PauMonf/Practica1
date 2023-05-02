package es.uji.al415716;

import es.uji.al415716.modelo.distance.EuclideanDistance;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanDistanceTest {

    @Test
    void calculateDistance() {
        EuclideanDistance eD = new EuclideanDistance();
        List<Double> a,b;

        a=List.of(0.0);
        b=List.of(1.0);
        assertEquals(1.0,eD.calculateDistance(a,b));
        a=List.of(0.0);
        b=List.of(-1.0);
        assertEquals(1.0,eD.calculateDistance(a,b));
        a=List.of(0.0,1.0);
        b=List.of(1.0,0.0);
        assertEquals(Math.sqrt(2),eD.calculateDistance(a,b));
        assertEquals(Math.sqrt(2),eD.calculateDistance(b,a));
        a=List.of(0.0,0.0,0.0);
        b=List.of(1.0,1.0,1.0);
        assertEquals(Math.sqrt(3),eD.calculateDistance(a,b));
        assertEquals(Math.sqrt(3),eD.calculateDistance(b,a));
        a=List.of(1.0,1.0,1.0,1.0);
        b=List.of(5.0,5.0,5.0,5.0);
        assertEquals(8.0,eD.calculateDistance(a,b));
        assertEquals(8.0,eD.calculateDistance(b,a));
    }
}