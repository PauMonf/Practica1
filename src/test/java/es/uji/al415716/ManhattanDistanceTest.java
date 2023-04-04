package es.uji.al415716;

import es.uji.al415716.Distance.EuclideanDistance;
import es.uji.al415716.Distance.ManhattanDistance;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanDistanceTest {

    @Test
    void calculateDistance() {
        ManhattanDistance mD = new ManhattanDistance();
        List<Double> a,b;

        a=List.of(0.0);
        b=List.of(1.0);
        assertEquals(1.0,mD.calculateDistance(a,b));
        a=List.of(0.0);
        b=List.of(-1.0);
        assertEquals(1.0,mD.calculateDistance(a,b));
        a=List.of(0.0,1.0);
        b=List.of(1.0,0.0);
        assertEquals(2,mD.calculateDistance(a,b));
        assertEquals(2,mD.calculateDistance(b,a));
        a=List.of(0.0,0.0,0.0);
        b=List.of(1.0,1.0,1.0);
        assertEquals(3,mD.calculateDistance(a,b));
        assertEquals(3,mD.calculateDistance(b,a));
        a=List.of(1.0,1.0,1.0,1.0);
        b=List.of(5.0,5.0,5.0,5.0);
        assertEquals(16f,mD.calculateDistance(a,b));
        assertEquals(16f,mD.calculateDistance(b,a));
    }
}