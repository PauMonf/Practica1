package es.uji.al415716.Algorithm;

import es.uji.al415716.Table.Table;

import java.util.*;
import java.util.List;

public class RecSys {
    private Algorithm algorithm;
    private List<String> testItemNames;
    private Map<Object, Set<Integer>> setsOfClasses;
    public RecSys(Algorithm algorithm){
        this.algorithm=algorithm;
    }
    public void train(Table trainData) throws Exception {
        algorithm.train(trainData);
    }

    public void run(Table testData, List<String> testItemNames) throws Exception {
        int rowsSize=testData.getRows().size();
        if(rowsSize!= testItemNames.size()) throw new Exception();

        this.testItemNames=testItemNames;
        setsOfClasses=new HashMap<>();
        Object estimation;
        for(int i=0;i<rowsSize;i++){
            estimation=algorithm.estimate(testData.getRowAt(i).getData());
            if(!setsOfClasses.containsKey(estimation))
                setsOfClasses.put(estimation,new HashSet<>());
            setsOfClasses.get(estimation).add(i);
        }

    }

    public List<String> recommend(String nameLikedItem, int numRecommendations) throws Exception {
        int position=testItemNames.indexOf(nameLikedItem);

        if(position==-1) throw new Exception();

        List<String> recommendations=new ArrayList<>(numRecommendations);
        Iterator<Integer> it=getClass(position).iterator();
        for(int i=0;i<numRecommendations && it.hasNext();i++){
            int positionRecommendation=it.next();
            if(positionRecommendation!=position)
                recommendations.add(testItemNames.get(positionRecommendation));
        }
        return recommendations;
    }

    public Set<Integer> getClass(int positionItem) throws Exception {
        for(Object key:setsOfClasses.keySet()){
            if(setsOfClasses.get(key).contains(positionItem))
                return setsOfClasses.get(key);
        }
        throw new Exception();
    }
}
