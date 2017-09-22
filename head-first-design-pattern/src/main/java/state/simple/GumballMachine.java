package state.simple;

/**
 * 糖果机的简单实现，没有封装变化
 *
 * @author youchao.wen
 * @date 2017/9/18.
 */
public class GumballMachine {
    /**
     * 售罄状态，即count = 0
     */
    public final static int SOLD_OUT = 0;
    /**
     * 机器中没有25分钱的状态
     */
    public final static int NO_QUARTER = 1;
    /**
     * 机器中有25分钱的状态
     */
    public final static int HAS_QUARTER = 2;
    /**
     * 正在出售状态
     */
    public final static int SOLD = 3;

    /**
     * 当前状态
     */
    public int state = SOLD_OUT;
    /**
     * 糖果库存
     */
    public int count = 0;
    /**
     * 构造器需要初始化糖果的数量作为库存。
     * 如果库存数量不为零的话，机器就会进入没有25分钱的状态(@NO_QUARTER)，即等待顾客投钱
     *
     * @param count
     */
    public GumballMachine(int count){
        this.count = count;
        if(count > 0) state = NO_QUARTER;
    }

    /**
     * 往机器投入25分钱
     */
    public void insertQuarter(){
        switch (state){
            /**
             * 机器一次只能接受一个25美分
             */
            case HAS_QUARTER :
                System.out.println("You can not insert another quarter");
                break;
            /**
             * 机器中没有25美分时，可以接受
             */
            case NO_QUARTER:
                state = HAS_QUARTER;
                System.out.println("one quarter inserted");
                break;
            case SOLD_OUT:
                System.out.println("sorry, gumballs sold out");
                break;
            case SOLD:
                System.out.println("please wait, you gumball is packing and delivering");
                break;
            default:
                break;
        }
    }

    /**
     * 退25美分
     */
    public void ejectQuarter(){
        switch (state){
            case HAS_QUARTER:
                System.out.println("return your quarter");
                state = NO_QUARTER;
                break;
            case NO_QUARTER:
                System.out.println("you did not insert a quarter");
                break;
            case SOLD:
                System.out.println("sorry, gumball already sold");
                break;
            case SOLD_OUT:
                System.out.println("you did not insert a quarter");
                break;
            default:
                break;
        }
    }

    /**
     * 转动曲柄
     */
    public void turnCrank(){
        switch (state){
            /**
             * 已出售，但是如果再转动曲柄则不会再吐糖果出来
             */
            case SOLD :
                System.out.println("Turning the crank twice doesn't get you another gumball");
                break;
            /**
             * 没投币就想获取糖果，没门
             */
            case NO_QUARTER :
                System.out.println("You turned but there is no Quarter");
                break;
            /**
             * 卖光了
             */
            case SOLD_OUT:
                System.out.println("You turned, but there are no gumballs");
                break;
            /**
             * 已投币，吐糖果
             */
            case HAS_QUARTER:
                System.out.println("You turned the crank, preparing gumballs...");
                state = SOLD;
                dispense();
                break;
            default:
                break;
        }
    }

    /**
     * 糖果发放
     */
    public void dispense(){
        switch (state){
            /**
             * 只有在SOLD状态才会吐出糖果
             */
            case SOLD:
                System.out.println("a gumball is rolling out the slot");
                count--;
                state = NO_QUARTER;
                System.out.println("gumball sold");
                if(count == 0){
                    System.out.println("oops, out of gumballs");
                    state = SOLD_OUT;
                }
                break;
            /**
             * 其余状态逻辑上来说不会进来，如果进来了就提示，但不会有实质性动作
             */
            default:
                System.out.println("you need to pay, or there is no gumballs to sold");
                break;
        }
    }

    @Override
    public String toString() {
        String stateStr = "";
        switch (state){
            case SOLD:
                stateStr = "SOLD";
                break;
            case HAS_QUARTER:
                stateStr = "HAS QUARTER";
                break;
            case NO_QUARTER:
                stateStr = "NO QUARTER";
                break;
            case SOLD_OUT:
                stateStr = "SOLD OUT";
                break;
            default:
                break;
        }
        return  "remain count -> " + count + ", " +
                "current state -> " + stateStr;
    }
}
