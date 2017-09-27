package compound.factory.impl;

import compound.duck.Quackable;
import compound.duck.ducks.MallardDuck;
import compound.duck.ducks.RedHeadDuck;
import compound.duck.fakeDucks.DuckCall;
import compound.duck.fakeDucks.RubberDuck;
import compound.factory.AbstractDuckFactory;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
