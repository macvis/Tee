package compound.duck;

import compound.observer.QuackObservable;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public interface Quackable extends QuackObservable {
    void quack();
}
