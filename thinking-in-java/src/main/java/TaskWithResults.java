import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * thinking in java page.658
 *
 * @author : 温友朝
 * @date : 2017/5/16
 */
public class TaskWithResults implements Callable<String> {
    private int id;

    public TaskWithResults(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskResult id = " + id;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            //submit方法会产生future对象
            //future对象是一个异步的对象类，可以接收处理好的submit对象
            list.add(es.submit(new TaskWithResults(i)));
        }

        try {
            for (Future<String> fs : list) {
                System.out.println(fs.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
