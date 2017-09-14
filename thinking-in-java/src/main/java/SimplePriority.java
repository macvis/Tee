import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 查看不同优先级的线程的执行情况
 *
 * @author : 温友朝
 * @date : 2017/5/16
 */
public class SimplePriority implements Runnable {

    private int countDown = 5;

    private volatile double d;

    private int priority;

    public SimplePriority(int priority){
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " +countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for(int i = 0; i < 100000; i++){
                d += (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0){
                    Thread.yield();
                }
                System.out.println(this);
                if(--countDown == 0) return;
            }
        }
    }

    public static void main(String[] args){
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            es.execute(new SimplePriority(Thread.MIN_PRIORITY));
        }
        es.execute(new SimplePriority(Thread.MAX_PRIORITY));
        es.shutdown();
    }
}
