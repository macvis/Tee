package singleton;

/**
 * 双检锁/双重校验锁
 *
 * @author youchao.wen
 * @date 2020/9/2.
 */
public class DoubleCheckedLockingSingleton {
    private volatile static DoubleCheckedLockingSingleton singleton;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getSingleton() {
        //第一层检查
        if (singleton == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                //第二层检查
                if (singleton == null) {
                    singleton = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return singleton;
    }
}
