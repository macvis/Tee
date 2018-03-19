
/**
 * @author youchao.wen
 * @date 2017/8/18.
 */
public class Tickets {

    private static ThreadLocal<Integer> TL = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 5;
        }
    };

    public void setValue() {
        int value = TL.get();
        value -= 1;
        TL.set(value);
    }

    public int getValue() {
        return TL.get();
    }

    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Mythread mt1 = new Mythread("ticket", tickets);
        new Thread(mt1, "window1").start();
        new Thread(mt1, "window2").start();
        new Thread(mt1, "window3").start();
    }


    private static class Mythread implements Runnable {
        int count = 5;
        String name;

        Tickets ticket;

        public Mythread(String name, Tickets ticket) {
            this.name = name;
            this.ticket = ticket;
        }

        @Override
        public void run() {
            while (count > 0) {
                System.out.println("name -> " + Thread.currentThread() +
                        ", tickets count -> " + count +
                        ", ThreadLocal -> " + ticket.getValue());
                ticket.setValue();
                count--;
            }
        }
    }
}
