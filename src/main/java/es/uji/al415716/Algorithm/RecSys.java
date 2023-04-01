package es.uji.al415716.Algorithm;

import es.uji.al415716.Table.Table;

import java.util.*;
import java.util.List;

public class RecSys {
    private Algorithm algorithm;
    private List<String> testItemNames;
    private Map<Object, Set<Integer>> classMap;

    public RecSys(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void train(Table trainData) throws Exception {
        algorithm.train(trainData);
    }

    public void run(Table testData, List<String> testItemNames) throws Exception {
        int rowsSize = testData.getRows().size();
        if (rowsSize != testItemNames.size()) throw new RecSysSizeException();

        this.testItemNames = testItemNames;
        classMap = new HashMap<>();
        Object estimation;
        for (int i = 0; i < rowsSize; i++) {
            estimation = algorithm.estimate(testData.getRowAt(i).getData());
            if (!classMap.containsKey(estimation))
                classMap.put(estimation, new HashSet<>());
            classMap.get(estimation).add(i);
        }

    }

    public List<String> recommend(String nameLikedItem, int numRecommendations) throws Exception {
        int position = testItemNames.indexOf(nameLikedItem);

        if (position == -1) throw new UndefinedNameException();

        List<String> recommendations = new ArrayList<>(numRecommendations);
        Iterator<Integer> it = getClassSet(position).iterator();
        for (int i = 0; i < numRecommendations && it.hasNext(); i++) {
            int positionRecommendation = it.next();
            if (positionRecommendation != position)
                recommendations.add(testItemNames.get(positionRecommendation));
        }
        return recommendations;
    }

    public Set<Integer> getClassSet(int positionItem) throws Exception {
        for (Object key : classMap.keySet()) {
            if (classMap.get(key).contains(positionItem))
                return classMap.get(key);
        }
        throw new Exception();
    }
}
