package headFirstDesignPattern.adaptorPattern.impl;

import headFirstDesignPattern.adaptorPattern.IDuck;

/**
 * Created by Tee on 2017/6/1.
 */
public class MallardDuck implements IDuck {
    @Override
    public void quack() {
        System.out.println("quack, quack");
    }

    @Override
    public void fly() {
        System.out.println("i'm flying!");
    }
}
