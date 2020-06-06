package subject1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 题目1：
 * 三个线程A、B、C，实现一个程序让线程A打印“阿”，线程B打印“里”，线程C打印“巴”，
 * 三个线程输出阿里巴巴阿里巴巴......阿里巴巴，循环10次“阿里巴巴”
 *
 * @author youchao.wen
 * @date 2020/4/19.
 */
public class Subject1 {
    public static void main(String[] args) {
        new PrintAlibaba().print();
    }

    static class PrintAlibaba {
        public void print() {
            ExecutorService single = Executors.newFixedThreadPool(1);
            for (int i = 0; i < 10; i++) {
                single.submit(new Task("阿"));
                single.submit(new Task("里"));
                single.submit(new Task("巴"));
                single.submit(new Task("巴"));
            }
        }

        class Task implements Runnable {
            private String print;
            public Task(String print) {
                this.print = print;
            }

            @Override
            public void run() {
                    System.out.print(print);
            }
        }
    }
}
