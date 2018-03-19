package multiThreadExercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 温友朝
 * @date : 2017/5/16
 */
public class Fibonacci implements Runnable {
    private int n = 0;

    private int result = 0;

    private List<Integer> list = new ArrayList<Integer>();

    public Fibonacci(int n) {
        this.n = n;
    }

    public void run() {
        if (n < 2) {
            throw new RuntimeException("boom");
        }

        generate(this.n);
        System.out.println(list.toString());
    }

    private void generate(int n) {
        int times = 1;
        list.add(0);
        list.add(1);
        while (times < n) {
            list.add(list.get(times) + list.get(times - 1));
            times++;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Fibonacci(10)).start();
        }
    }
}
