package compound.observer;


/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObserver();
}
