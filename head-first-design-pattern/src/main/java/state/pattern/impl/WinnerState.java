package state.pattern.impl;

import state.pattern.GumballMachine;
import state.pattern.State;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class WinnerState implements State {

    GumballMachine machine;

    public WinnerState(){}

    public WinnerState(GumballMachine machine){
        this.machine = machine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("already got one quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("ejecting your quarter");
        machine.setState(GumballMachine.NO_QUARTER_STATE);
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned the crank, congratulations, you are a winner, you can get two gumballs");
    }

    @Override
    public void dispense() {
        machine.releaseTwoGumaballs();
        if(machine.count > 0){
            machine.setState(GumballMachine.NO_QUARTER_STATE);
        }
    }
}
