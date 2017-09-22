package state.simple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import state.simple.GumballMachine;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class GumballMachineTest {

    GumballMachine machine;

    @Before
    public void init(){
        machine = new GumballMachine(5);
    }

    @After
    public void destroy(){
        machine = null;
    }

    @Test
    public void testDrive(){
        System.out.println("=======prepare gumball machine=======");
        System.out.println(machine);

        System.out.println("=======buy one gumball========");
        machine.insertQuarter();
        machine.turnCrank();
        System.out.println(machine + "\n");

        System.out.println("=======insert one quarter and reject========");
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();
        System.out.println(machine + "\n");

        System.out.println("=======buy one gumball, insert one quarter and reject=======");
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        machine.ejectQuarter();
        System.out.println(machine + "\n");

        System.out.println("======insert 4 quarter and turn crank 3 times========");
        machine.insertQuarter();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        System.out.println(machine + "\n");
    }
}
