package compound.factory;

import compound.duck.Quackable;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedHeadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();
}
