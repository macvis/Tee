package singleton;

/**
 * 懒汉式,线程不安全的单例写法
 *
 * @author youchao.wen
 * @date 2020/9/2.
 */
public class LazySingletonNotThreadSafe {
    private static LazySingletonNotThreadSafe instance;
    private LazySingletonNotThreadSafe(){}

    public static LazySingletonNotThreadSafe getInstance() {
        if (instance == null) {
            instance = new LazySingletonNotThreadSafe();
        }
        return instance;
    }
}
