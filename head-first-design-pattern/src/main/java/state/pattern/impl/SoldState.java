package state.pattern.impl;

import state.pattern.GumballMachine;
import state.pattern.State;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class SoldState implements State {
    GumballMachine machine;

    public SoldState(){}

    public SoldState(GumballMachine machine){
        this.machine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert another quarter while we ready get one");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("sorry, you already turn the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("sorry, turning the crank twice doesn't mean you can get two of them");
    }

    @Override
    public void dispense() {
        machine.release();
        if(machine.count > 0){
            machine.setState(GumballMachine.NO_QUARTER_STATE);
        }
    }
}
