package multiThreadExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author : 温友朝
 * @date : 2017/5/16
 */
public class FibonacciCallableImpl implements Callable<Integer> {

    private static int n = 0;

    private static List<Integer> list = new ArrayList<Integer>();

    public FibonacciCallableImpl(int num ){
        this.n = num;
    }

    public Integer call() throws Exception {
        if(n < 2){
            throw new RuntimeException("boom");
        }

        list = new ArrayList<Integer>();

        int time = 1;
        list.add(0);
        list.add(1);
        while (time < n){
            list.add(list.get(time - 1) + list.get(time));
            time++;
        }
        int res = 0;
        for(int i : list){
            res += i;
        }
        return res;
    }

    public static void main(String[] args){
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        ExecutorService es = Executors.newFixedThreadPool(1);
        for(int i = 0; i < 5; i++){
            list.add(es.submit(new FibonacciCallableImpl(10)));
        }
        es.shutdown();

        try{
            for(Future<Integer> fu : list){
                System.out.println(fu.get());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
