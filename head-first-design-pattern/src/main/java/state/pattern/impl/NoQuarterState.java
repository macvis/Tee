package state.pattern.impl;

import state.pattern.GumballMachine;
import state.pattern.State;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class NoQuarterState implements State {

    GumballMachine machine;

    public NoQuarterState() {
    }

    public NoQuarterState(GumballMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you inserted a Quarter");
        machine.setState(GumballMachine.HAS_QUARTER_STATE);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you have not inserted a Quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned, but there is no Quarter");
    }

    @Override
    public void dispense() {
        System.out.println("you need to pay first");
    }
}
