package singleton;

/**
 * 懒汉式,线程安全的单例写法
 *
 * @author youchao.wen
 * @date 2020/9/2.
 */
public class LazySingletonWithThreadSafe {
    private static LazySingletonWithThreadSafe instance;

    private LazySingletonWithThreadSafe() {
    }

    public static synchronized LazySingletonWithThreadSafe getInstance() {
        if (instance == null) {
            instance = new LazySingletonWithThreadSafe();
        }
        return instance;
    }
}
