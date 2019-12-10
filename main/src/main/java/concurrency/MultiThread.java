package concurrency;

import java.util.TreeSet;

/**
 * @author youchao.wen
 * @date 2019/10/27.
 */
public class MultiThread {

    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        ts.add("st");
        ts.add("aa");
        ts.add("bb");
        ts.add("cc");
        ts.add("aa");

        System.out.println("ts -> " + ts);
    }
}
