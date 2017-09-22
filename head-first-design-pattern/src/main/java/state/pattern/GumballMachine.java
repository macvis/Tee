package state.pattern;

import state.pattern.impl.HasQuarterState;
import state.pattern.impl.NoQuarterState;
import state.pattern.impl.SoldOutState;
import state.pattern.impl.SoldState;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class GumballMachine {
    public static final State HAS_QUARTER_STATE = new HasQuarterState();
    public static final State NO_QUARTER_STATE  = new NoQuarterState();
    public static final State SOLD_STATE        = new SoldState();
    public static final State SOLD_OUT_STATE    = new SoldOutState();

    State state = SOLD_OUT_STATE;
    public int count = 0;

    public GumballMachine(int count){
        this.count = count;
        if(count > 0) state = NO_QUARTER_STATE;
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state){
        this.state = state;
    }

    public void release(){
        System.out.println("a gumball is rolling out...");
        if(count > 0) count--;
    }
}
