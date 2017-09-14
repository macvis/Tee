package multiThreadExercise;

/**
 * @author : 温友朝
 * @date : 2017/5/16
 */
public class Thread1 implements Runnable {
    private static int id = 0;

    private final int taskCount = id++;

    public Thread1(){
        System.out.print("thread1 taskCount=" + taskCount + " initialized");
        System.out.println("\n");
    }

    public void run() {
        System.out.print("thread1 taskCount=" + taskCount + " message = 'hello world'");
        System.out.println("\n");
    }

    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            new Thread(new Thread1()).start();
            System.out.println("thread " + i + " closing");
            Thread.yield();
        }
    }
}
