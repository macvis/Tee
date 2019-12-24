package concurrency;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * @author youchao.wen
 * @date 2019/10/27.
 */
public class MultiThread {

    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("st");
        ts.add("aa");
        ts.add("bb");
        ts.add("cc");
        ts.add("aa");

        System.out.println("ts -> " + ts);

        ExecutorService es = new ThreadPoolExecutor(1, 10, 1000,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("threadName").build());

        ExecutorService es2 = new ThreadPoolExecutor(1, 20, 1000, TimeUnit.MILLISECONDS,
               new LinkedBlockingQueue<>(),  new ThreadFactoryBuilder().setNameFormat("name-").build());
        es2.submit(() -> System.out.println("111"));
    }
}
