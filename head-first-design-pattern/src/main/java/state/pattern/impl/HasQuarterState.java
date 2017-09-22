package state.pattern.impl;

import state.pattern.GumballMachine;
import state.pattern.State;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class HasQuarterState implements State {
    GumballMachine machine;

    public HasQuarterState(){}

    public HasQuarterState(GumballMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you inserted a quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("quarter ejected");
        this.machine.setState(GumballMachine.NO_QUARTER_STATE);
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned the crank, preparing gumball...");
        this.machine.setState(GumballMachine.SOLD_STATE);
    }

    @Override
    public void dispense() {
        System.out.println("no gumball to dispense");
    }
}
