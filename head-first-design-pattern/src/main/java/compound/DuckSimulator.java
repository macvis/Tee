package compound;

import compound.adaptors.GooseAdaptor;
import compound.decorator.QuackCounter;
import compound.duck.Quackable;
import compound.factory.AbstractDuckFactory;
import compound.factory.impl.CountingDuckFactory;
import compound.flock.Flock;
import compound.goose.Goose;

/**
 * @author youchao.wen
 * @date 2017/9/26.
 */
public class DuckSimulator {

    public static void main(String[] args) {
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        new DuckSimulator().simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedHeadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdaptor(new Goose());

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());
        flockOfMallards.add(duckFactory.createMallardDuck());

        flockOfDucks.add(flockOfMallards);

        System.out.println("------the whole duck flock------");
        simulate(flockOfDucks);

        System.out.println("------the mallard duck flock------");
        simulate(flockOfMallards);

        System.out.println("duck quacked " + QuackCounter.geiQuacks() + " times");
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}
