package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author youchao.wen
 * @date 2017/8/18.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " - " + this);
            }
        }catch(Exception e){
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws  Exception{
        for(int i = 0; i < 5; i ++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }

        /**
         * main线程是前台线程
         * 当前台线程结束后，后台线程就会被杀死
         *
         * -->  所以这5个前台线程在main线程结束之后就被强制kill了
         */
        System.out.println("all daemons are started");
//        TimeUnit.MILLISECONDS.sleep(1000);
        Thread.sleep(200);


        Thread dae = new Thread(new ADaemon());
        dae.setDaemon(true);
        dae.start();
    }


    private static class ADaemon implements Runnable{
        @Override
        public void run() {
            try{
                System.out.println("start ADaemon");
                TimeUnit.MILLISECONDS.sleep(200);
            }catch(Exception e){
                System.out.println("exception");
            }finally{
                System.out.println("finally _>");
            }
        }
    }


}
