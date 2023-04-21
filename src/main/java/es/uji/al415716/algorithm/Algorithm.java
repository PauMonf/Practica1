package es.uji.al415716.algorithm;

import es.uji.al415716.table.Table;

public interface Algorithm <T extends Table, D, R>{
    public void train(T data) throws Exception;
    public R estimate(D data) throws Exception;

}
