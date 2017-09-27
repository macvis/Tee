package compound.factory.impl;

import compound.decorator.QuackCounter;
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
public class CountingDuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounter(new RedHeadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
