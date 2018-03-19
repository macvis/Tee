package compound.duck.fakeDucks;

import compound.duck.Quackable;
import compound.observer.Observer;
import compound.observer.impl.Observable;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class RubberDuck implements Quackable {
    Observable observable;

    public RubberDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Squeak");
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
