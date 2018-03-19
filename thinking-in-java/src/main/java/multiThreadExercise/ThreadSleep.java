package multiThreadExercise;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * sleep期间另外的进程同样可以执行
 *
 * @author : 温友朝
 * @date : 2017/5/16
 */
public class ThreadSleep implements Runnable {

    private int id = 0;

    private long sleepTime = 0;

    public ThreadSleep(int id, long sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
    }

    public void run() {

        try {
            long start = System.currentTimeMillis();
            Thread.sleep(sleepTime);
            long end = System.currentTimeMillis();
            long gap = end - start;

            System.out.println("id = " + id + ", time gap = " + gap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            System.out.println("thread" + i + " :");
            long time = new Random().nextInt(10000);
            System.out.println("sleep time = " + time);
            System.out.print("\n");
            es.execute(new ThreadSleep(i, time));
        }
    }
}
