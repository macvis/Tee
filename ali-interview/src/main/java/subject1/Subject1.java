package subject1;

import java.util.concurrent.CyclicBarrier;

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
            Thread threadA = new Thread(new TaskA());
            Thread threadLi = new Thread(new TaskLi());
            Thread threadBa1 = new Thread(new TaskBa1());
            Thread threadBa2 = new Thread(new TaskBa2());
            for (int i = 0; i < 10; i++) {
                threadA.start();
                threadLi.start();
                threadBa1.start();
                threadBa2.start();
            }
        }

        class TaskA implements Runnable {
            CyclicBarrier barrier;

            public TaskA() {
            }

            @Override
            public void run() {
                System.out.print("阿");
            }
        }

        class TaskLi implements Runnable {

            @Override
            public void run() {
                System.out.print("里");
            }
        }

        class TaskBa1 implements Runnable {

            @Override
            public void run() {
                System.out.print("巴");
            }
        }

        class TaskBa2 implements Runnable {

            @Override
            public void run() {
                System.out.print("巴");
            }
        }
    }
}
