package demoPack;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author youchao.wen
 * @date 2019-04-23.
 */
public class TestStreamAPI {

    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("hello", "world", "as", "the", "best", "day");

        String phrase = list.stream()
                .reduce("sentence: ", (s1, s2) -> s1 + " " + s2);
        System.out.println("phrase -> " + phrase);


        int totalLength2 = list.parallelStream()
                .reduce(0,
                        (sum, s) -> {
                            sum += s.length();
                            System.out.println("累加器");
                            return sum;
                        },
                        (sum1, sum2) -> {
                            int sum = sum1 + sum2;
                            System.out.println("组合器");
                            return sum;
                        });
        System.out.println("totalLength2 -> " + totalLength2);



        list.parallelStream()
                .filter(s -> {
                    System.out.println("s.filter -> " + s);
                    return true;
                })
                .map(String :: toUpperCase)
                .forEach(s -> System.out.println("s.forEach -> " + s));

    }

    @Data
    public static class Count {
        int num;
        String numName;

        public Count(int num, String numName) {
            this.num = num;
            this.numName = numName;
        }
    }

}
