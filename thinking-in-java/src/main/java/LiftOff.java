/**
 * Thinking in Java Page.654
 *
 * @author : 温友朝
 * @date : 2017/5/16
 */
public class LiftOff implements Runnable{
    private int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "liftOff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
        System.out.println("");
    }

    public static void main(String[] args){
        //1. 试验run方法
//        new Thread1(new LiftOff()).start();
        //2、多线程执行
        for(int i = 0; i < 5; i++){
            new Thread(new LiftOff()).start();
            System.out.println("run method completed inside circle");
        }
//        /**
//         * 之所以这一段先于status()输出，
//         * 是因为thread的start方法是根据cpu时间片来切换运行线程的run方法的，
//         * 所以这个方法执行完了run()方法还没有轮到
//         */
//        System.out.println("run method completed");
        //3、使用cachedThreadPool
//        ExecutorService es = Executors.newCachedThreadPool();
//        for(int i = 0; i < 5; i++){
//               es.execute(new LiftOff(10));
//        }
        // 显式的调用shutdown()方法会引起java.util.concurrent.RejectedExecutionException
////            es.shutdown();
        //4、使用fixedThreadPool
//        ExecutorService es = Executors.newFixedThreadPool(5);
//        for(int i = 0; i < 5; i ++){
//            es.execute(new LiftOff(10));
////            es.shutdown();
//        }
        //5、使用SingleThreadExecutor
//        ExecutorService es = Executors.newSingleThreadExecutor();
//        for(int i = 0; i < 5; i++){
//            es.execute(new LiftOff(10));
//        }
//        es.shutdown();
    }
}
