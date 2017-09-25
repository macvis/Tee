package state.pattern;

import state.pattern.impl.*;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class GumballMachine {
    public static final State HAS_QUARTER_STATE = new HasQuarterState();
    public static final State NO_QUARTER_STATE  = new NoQuarterState();
    public static final State SOLD_STATE        = new SoldState();
    public static final State SOLD_OUT_STATE    = new SoldOutState();
    public static final State WINNER_STATE      = new WinnerState();

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
        if(count > 0) {
            count--;
        }else{
            this.setState(SOLD_OUT_STATE);
        }
    }

    public void releaseTwoGumaballs(){
        if(count > 2){
            count -= 2;
            System.out.println("2 gumballs is rolling out...");
            this.setState(NO_QUARTER_STATE);
        } else if(count == 2){
            count -= 2;
            System.out.println("2 gumballs is rolling out...");
            System.out.println("gumballs sold out");
            this.setState(SOLD_OUT_STATE);
        }else if(count < 2){
            System.out.println("oops, you can not get two gumballs due to only one left");
            this.ejectQuarter();
        }
    }
}
