package fun_interfaces;

/**
 * Created by youchao.wen on 2017/8/9.
 */
@FunctionalInterface
public interface Fruit {
    default String name() {
        return "fruit";
    }

    default String color() {
        return "green";
    }

    void weigh(int scale);

//    void eat();


}
