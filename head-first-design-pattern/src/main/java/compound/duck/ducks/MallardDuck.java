package compound.duck.ducks;

import compound.duck.Quackable;
import compound.observer.impl.Observable;

import java.util.Observer;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class MallardDuck implements Quackable {
    Observable observable;

    public MallardDuck() {
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObserver();
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
