package state.pattern;

/**
 * @author youchao.wen
 * @date 2017/9/18.
 */
public interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
