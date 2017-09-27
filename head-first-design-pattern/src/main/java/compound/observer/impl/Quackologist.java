package compound.observer.impl;

import compound.observer.Observer;
import compound.observer.QuackObservable;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist : " + duck + "just quacked");
    }
}
