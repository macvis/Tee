package compound.observer.impl;

import compound.observer.Observer;
import compound.observer.QuackObservable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class Observable implements QuackObservable {
    List<Observer> observers = new ArrayList<>();
    QuackObservable duck;

    public Observable(QuackObservable duck){
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer obs : observers){
            obs.update(duck);
        }
    }
}
