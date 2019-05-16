package demoPack;

import lombok.Data;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * @author youchao.wen
 * @date 2019-04-23.
 */
public class TestStreamAPI {

    public static void main(String[] args) {

        Set<String> androidSet = new TreeSet<>();
//        Set<String> iosSet = new TreeSet<>();
//        Set<String> h5Set = new TreeSet<>();
//
//        List<String> types = Arrays.asList("IOS", "ANDROID", "H5", "ALL", "AND_ONE");
//
//        types.stream()
//                .filter(type -> StringUtils.contains(type, "AND"))
//                .forEach(androidSet::add);
//
//        types.stream().filter(type -> StringUtils.equals(type, "IOS"))
//                .findAny().ifPresent(iosSet::add);
//
//        types.stream()
//                .filter(type -> StringUtils.equals(type, "H5"))
//                .findAny()
//                .ifPresent(h5Set::add);
//
//        types.stream().filter(type -> StringUtils.equals(type, "ALL"))
//                .findAny().ifPresent(type ->
//        {
//            //转换ANDROID
//            androidSet.add(type);
//            //转换IOS
//            iosSet.add(type);
//        });
//
//
//        System.out.println("h5 -> " + JSON.toJSONString(h5Set));
//        System.out.println("android -> " + JSON.toJSONString(androidSet));
//        System.out.println("ios -> " + JSON.toJSONString(iosSet));
//        System.out.println("all -> " + JSON.toJSONString(androidSet) + "-----" + JSON.toJSON(iosSet));
//        System.out.println();
//
//        Stream.of("a1,", "a2,", " ", "a3")
//                .filter(StringUtils :: isNotBlank)
//                .map(s -> s.substring(1, 2))
//                .map(Integer :: parseInt)
//                .forEach(System.out :: print);

//        IntStream.range(0, 3)
//                .mapToObj(i -> new Count(i, "name : " + i))
//                .forEach(System.out::println);

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return true;
//                })
//                .forEach(s -> System.out.println("forEach: " + s));

        boolean match = Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    // 过滤出以 A 为前缀的元素
                    return s.startsWith("E");
                });
        System.out.print("match -> " + match);
    }

    @Data
    public static class Count{
        int num;
        String numName;

        public Count(int num, String numName){
            this.num = num;
            this.numName = numName;
        }
    }

}
