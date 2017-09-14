import fun_interfaces.Fruit;

import java.util.Arrays;
import java.util.List;

/**
 * Created by youchao.wen on 2017/8/7.
 */
public class Demo {


    public static void main(String[] args){
        Runnable r = () -> {System.out.println("xxoo");};

        Fruit fruit = (int x) -> {System.out.println("eating" + x);};

        List<String> list = Arrays.asList("a", "b", "c", "d", "A", "B", "C", "D");
        list.sort(String::compareToIgnoreCase);

    }
}
