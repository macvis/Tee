package compound.duck.ducks;

import compound.duck.Quackable;
import compound.observer.Observer;
import compound.observer.impl.Observable;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class RedHeadDuck implements Quackable {
    Observable observable;

    public RedHeadDuck(){
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObserver() {
        observable.notifyObserver();
    }
}
