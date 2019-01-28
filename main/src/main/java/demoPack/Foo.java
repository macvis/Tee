package demoPack;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Tee on 2017/5/25.
 */
public class Foo {

    public static void main(String[] args) {
//        BigDecimal num = new BigDecimal("1");
//        for (int i = 0; i < 2000; i++) {
//            num = num.multiply(new BigDecimal(i + 1));
//        }
//        String numStr = num.toString();
//        System.out.println("num = " + numStr);
//        int numLength = numStr.length();
//        System.out.println("num length = " + numLength);
//
//        int zeroCount = 0;
//        for (int i = 0; i < numLength; i++) {
//            char c = numStr.charAt(i);
//            if(c == '0'){
//                zeroCount++;
//            }
//        }
//        System.out.println("zero count = " + zeroCount);

        List<String> list = new ArrayList<>();
//        list.add(null);
        System.out.println("list.add(null);");
        System.out.println("CollectionUtils.isEmpty(list) -> " + CollectionUtils.isEmpty(list));
        System.out.println("list.get(0) ->" + list.get(0));
        System.out.println("list.isEmpty() ->" + list.isEmpty());
    }

    private void out() {

    }

    /**
     * 提供将String类型的字符串内容，转化为Map
     * 原始格式(String)：epay易信组;10.120.83.97:6801|epay用户组;10.120.82.201:6801
     * 输出格式(Map<String, String>):{{epay易信组:10.120.83.97:6801}}{epay用户组:10.120.82.201:6801}}
     *
     * @param str
     * @return
     */
    public static Map<String, String> string2MapStr(String str, String masterSplit, String slaveSplit) {
        String[] strs = str.split(masterSplit);
        Map<String, String> resultMap = new TreeMap<>();

        for (String item : strs) {
            //对于每一类的server组，第一个;前为其组名
            String[] itemList = item.split(slaveSplit);
            String key = itemList[0];
            String value = itemList[1];
            resultMap.put(key, value);
        }
        return resultMap;
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
