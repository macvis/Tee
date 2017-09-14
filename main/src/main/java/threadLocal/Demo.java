package threadLocal;

/**
 * ThreadLocal学习类
 *
 * @author youchao.wen
 * @date 2017/8/17.
 */
public class Demo {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        public String initialValue(){
            return "init";
        }
    };

    public String getNext(){
        threadLocal.set(threadLocal.get().concat("NewValue"));
        return threadLocal.get();
    }

    public static void main(String[] args){
        Demo demo = new Demo();
        TestThread test1 = new TestThread(demo);
        TestThread test2 = new TestThread(demo);
        TestThread test3 = new TestThread(demo);

        new Thread(test1).start();
        new Thread(test2).start();
        new Thread(test3).start();

    }

    private static class TestThread implements Runnable{

        private Demo demo;

        public TestThread(Demo demo){
            this.demo = demo;
        }

        @Override
        public void run() {
            for(int i = 0; i < 3; i ++){
                System.out.println("thread -> " + Thread.currentThread());
                System.out.println("threadLocal -> " + demo.getNext());
            }
        }
    }
}
