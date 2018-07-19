package demoPack;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Tee on 2017/5/25.
 */
public class Foo {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("0.0000").stripTrailingZeros();
        BigDecimal b2 = new BigDecimal("0");
        System.out.println(b1.equals(BigDecimal.ZERO));
        System.out.println(b2.equals(BigDecimal.ZERO));
    }

    private void out() {

    }

    static class Goo {
        protected String s1;
        protected String s2;

        private BigDecimal num;

        private Timestamp time1;
        private Timestamp time2;

        public Goo() {

        }

        public Goo(BigDecimal num, String s1) {
            this.num = num;
            this.s1 = s1;
        }

        public BigDecimal getNum() {
            return num;
        }

        public void setNum(BigDecimal num) {
            this.num = num;
        }

        public String getS1() {
            return s1;
        }

        public void setS1(String s1) {
            this.s1 = s1;
        }

        public String getS2() {
            return s2;
        }

        public void setS2(String s2) {
            this.s2 = s2;
        }

        public Timestamp getTime1() {
            return time1;
        }

        public void setTime1(Timestamp time1) {
            this.time1 = time1;
        }

        public Timestamp getTime2() {
            return time2;
        }

        public void setTime2(Timestamp time2) {
            this.time2 = time2;
        }

        //        protected void write() {
//            System.out.println("xxoo");
//        }
    }


}
