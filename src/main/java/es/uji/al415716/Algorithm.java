package es.uji.al415716;

public interface Algorithm <T extends Table, D, R>{
    public void train(T data) throws Exception;
    public R estimate(D data) throws Exception;

}
