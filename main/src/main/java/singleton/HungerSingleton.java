package singleton;

/**
 * 饿汉式
 *
 * @author youchao.wen
 * @date 2020/9/2.
 */
public class HungerSingleton {
    private static HungerSingleton instance = new HungerSingleton();

    private HungerSingleton() {
    }

    public static HungerSingleton getInstance() {
        return instance;
    }
}
