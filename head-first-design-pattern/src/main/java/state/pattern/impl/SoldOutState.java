package state.pattern.impl;

import state.pattern.State;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class SoldOutState implements State {
    @Override
    public void insertQuarter() {
        System.out.println("you inserted a Quarter, but gumballs sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("ejecting your quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned the crank, but gumballs sold out");
    }

    @Override
    public void dispense() {
        System.out.println("gumballs sold out, unable to dispense");
    }
}
