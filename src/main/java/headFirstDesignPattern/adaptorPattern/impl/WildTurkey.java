package headFirstDesignPattern.adaptorPattern.impl;

import headFirstDesignPattern.adaptorPattern.ITurkey;

/**
 * Created by Tee on 2017/6/1.
 */
public class WildTurkey implements ITurkey{
    @Override
    public void gobble() {
        System.out.println("gobble, gobble");
    }

    @Override
    public void fly() {
        System.out.println("i'm flying, but not a long distance");
    }
}
