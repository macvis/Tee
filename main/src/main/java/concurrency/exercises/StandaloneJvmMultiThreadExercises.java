package concurrency.exercises;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 一些单机的多线程练习题
 *
 * @author youchao.wen
 * @date 2020/5/16.
 */
public class StandaloneJvmMultiThreadExercises {

    /**
     * 假设车库有3个车位可以停车
     * 写一个程序模拟多个用户开车离开，停车入库的效果
     * 注意：车位有车时不能停车
     * <p>
     * 思路1：
     * 简化为多线程抢夺3个资源的过程，且这3个资源没有顺序要求 => 设计一个重入锁。
     * --难度太高，暂时不做
     * 思路2：
     * 抽取入停车场行为、离开停车场行为 成为两个线程，模拟这两个行为对资源的处理
     */
    static class ParkingLotSolution {
        //车位，即多线程中的资源池
        volatile static int parkingLots = 3;
        final static Object object = new Object();

        //使用synchronized关键字解决
        private static void solveBySynchronized() {
            Thread parkAction = new Thread(() -> {
                synchronized (object) {
                    for (int i = 0; i < 100; i++) {
                        try {
                            //车位不够就阻塞
                            if (parkingLots == 0) {
                                object.wait();
                            } else {
                                parkingLots--;
                                System.out.println("已停好车，剩余车位数 -> " + parkingLots);
                                //通知释放车位的线程可以行动了
                                object.notifyAll();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            Thread unParkAction = new Thread(() -> {
                synchronized (object) {
                    for (int i = 0; i < 100; i++) {
                        try {
                            Thread.sleep(100L);
                            //车位全空代表无车可出，阻塞等待
                            if (parkingLots == 3) {
                                object.wait();
                            } else {
                                parkingLots++;
                                //通知停车线程可进入工作
                                object.notify();
                                System.out.println("离开停车场时 此时的车位数 -> " + parkingLots);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            parkAction.start();
            unParkAction.start();
        }

        static class ParkCarProducer implements Runnable {
            BlockingQueue<Object> queue;

            ParkCarProducer(BlockingQueue<Object> queue) {
                this.queue = queue;
            }

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        queue.put(new Object());
                        System.out.println("被占用车位数 = " + queue.size());
                        System.out.println("车已停，剩余车位=" + (parkingLots - queue.size()));
                        System.out.println("");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        static class ParkCarConsumer implements Runnable {
            BlockingQueue<Object> queue;

            ParkCarConsumer(BlockingQueue<Object> queue) {
                this.queue = queue;
            }

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        queue.take();
                        System.out.println("车已离，剩余车位=" + (parkingLots - queue.size()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //使用阻塞队列解决
        private static void solveByBlockingQueue() {
            BlockingQueue<Object> queue = new ArrayBlockingQueue<>(parkingLots);
            new Thread(new ParkCarProducer(queue)).start();
            new Thread(new ParkCarConsumer(queue)).start();
        }

        public static void main(String[] args) {
//            solveBySynchronized();
            solveByBlockingQueue();
        }
    }

    /**
     * 编写程序实现,子线程循环3次,接着主线程循环5次,接着再子线程循环3次,主线程循环5次,如此反复,循环3次.
     */
    static class ThreadRunningCircles {
        private static Object lock = new Object();
        private volatile static int printOrder = 0;

        public static void main(String[] args) {
            for (int index = 0; index < 3; index++) {
                new Thread(() -> {
                    synchronized (lock) {
                        try {
                            if (printOrder == 0) {
                                for (int i = 0; i < 3; i++) {
                                    System.out.println("main thread print i = " + i);
                                }
                                printOrder = 1;
                                lock.notifyAll();
                            } else {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();

                new Thread(() -> {
                    synchronized (lock) {
                        try {
                            if (printOrder == 1) {
                                for (int i = 0; i < 5; i++) {
                                    System.out.println("sub thread print i = " + i);
                                }
                                printOrder = 0;
                                lock.notifyAll();
                            } else {
                                lock.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }

    /**
     * 设计四个线程,其中两个线程每次对变量i加1,另外两个线程每次对i减1.
     */
    static class AddOrSubtract {
        final static Object lock = new Object();
        private static volatile int index = 0;

        public static void main(String[] args) {
            for (int i = 0; i < 100; i++) {
                new Thread(() -> {
                    synchronized (lock) {
                        index++;
                        System.out.println("thread 1 added => " + index);
                    }
                }).start();

                new Thread(() -> {
                    synchronized (lock) {
                        try {
                            index++;
                            System.out.println("thread 2 added => " + index);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                new Thread(() -> {
                    synchronized (lock) {
                        try {
                            index--;
                            System.out.println("thread 3 subtracted => " + index);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                new Thread(() -> {
                    synchronized (lock) {
                        try {
                            index--;
                            System.out.println("thread 4 subtracted => " + index);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }

    /**
     * 使用多线程顺序打印ABCDEFG
     */
    static class OrderlyRunningThreads {
        private static final String[] strArr = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        private static volatile int index = 0;

        private static final Object lock = new Object();

        public static void main(String[] args) {
            //打印奇数位字符的线程
            new Thread(() -> {
                synchronized (lock) {
                    while (index < strArr.length) {
                        try {
                            if (index % 2 == 1) {
                                System.out.print(strArr[index]);
                                index++;
                                lock.notifyAll();
                            } else {
                                lock.wait();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            //打印偶数位字符的线程
            new Thread(() -> {
                synchronized (lock) {
                    while (index < strArr.length) {
                        try {
                            if (index % 2 == 0) {
                                System.out.print(strArr[index]);
                                index++;
                                lock.notifyAll();
                            } else {
                                lock.wait();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

    }

    /**
     * 编写两个线程，一个打印1-52，另一个打印A-Z。打印顺组为12A34B56C...51Y52Z
     */
    static class PrintCharactersOrderly {
        private static final Object lock = new Object();
        private static volatile int printOrder = 0;
        private static volatile int printIndex = 1;
        private static final Integer TIMES = 52;
        private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public static void main(String[] args) {
            new Thread(() -> {
                while (printIndex < TIMES) {
                    synchronized (lock) {
                        try {
                            if (printOrder == 0) {
                                String character1 = printIndex + "";
                                String character2 = printIndex + 1 + "";
                                System.out.print(character1 + character2);
                                printOrder = 1;
                                printIndex ++;
                                lock.notifyAll();
                            } else {
                                lock.wait();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(() -> {
                while (printIndex < TIMES + 1) {
                    synchronized (lock) {
                        try {
                            if (printOrder == 1) {
                                String character1 = LETTERS.charAt(printIndex / 2 - 1) + "";
                                System.out.print(character1);
                                printIndex ++;
                                printOrder = 0;
                                lock.notifyAll();
                            } else {
                                lock.wait();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
