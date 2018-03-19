package compound.decorator;

import compound.duck.Quackable;
import compound.observer.impl.Observable;

import java.util.Observer;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class QuackCounter implements Quackable {
    Quackable duck;
    static int count;

    Observable observable;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        duck.quack();
        count++;
    }

    public static int geiQuacks() {
        return count;
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
