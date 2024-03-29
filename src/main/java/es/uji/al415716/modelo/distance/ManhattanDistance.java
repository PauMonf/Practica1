package es.uji.al415716.modelo.distance;

import java.util.List;

public class ManhattanDistance implements Distance{
    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        double distance = 0;
        for (int i = 0; i < p.size(); i++) {
            distance += Math.abs(p.get(i) - q.get(i));
        }
        return distance;
    }
}
