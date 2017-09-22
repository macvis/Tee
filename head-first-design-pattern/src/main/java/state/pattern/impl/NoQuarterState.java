package state.pattern.impl;

import state.pattern.GumballMachine;
import state.pattern.State;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class NoQuarterState implements State {

    GumballMachine machine;

    public NoQuarterState(){}

    public NoQuarterState(GumballMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
