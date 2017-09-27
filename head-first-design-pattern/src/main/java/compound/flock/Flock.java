package compound.flock;

import compound.duck.Quackable;
import compound.observer.Observer;
import compound.observer.QuackObservable;
import compound.observer.impl.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class Flock implements Quackable {
    List<Quackable> flock = new ArrayList<>();
    QuackObservable observable;

    public void add(Quackable quacker){
        flock.add(quacker);
        observable = new Observable(this);
    }

    @Override
    public void quack() {
        for(Quackable quacker : flock){
            quacker.quack();
        }
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
