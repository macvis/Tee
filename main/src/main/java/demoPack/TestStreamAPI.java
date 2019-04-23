package demoPack;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author youchao.wen
 * @date 2019-04-23.
 */
public class TestStreamAPI {

    public static void main(String[] args) {

        Set<String> androidSet = new TreeSet<>();
        Set<String> iosSet = new TreeSet<>();
        Set<String> h5Set = new TreeSet<>();

        List<String> types = Arrays.asList("IOS", "ANDROID", "H5", "ALL", "AND_ONE");

        types.stream()
                .filter(type -> StringUtils.contains(type, "AND"))
                .forEach(type -> assembleAndroidAppDTO(androidSet, type));

        types.stream().filter(type -> StringUtils.equals(type, "IOS"))
                .findAny().ifPresent(type -> assembleIOSAppDTO(iosSet, type));

        types.stream().filter(type -> StringUtils.equals(type, "H5"))
                .findAny().ifPresent(type -> assembleH5AppDTO(h5Set, type));

        types.stream().filter(type -> StringUtils.equals(type, "ALL"))
                .findAny().ifPresent(type ->
        {
            //转换ANDROID
            assembleAndroidAppDTO(androidSet, "ANDROID");
            //转换IOS
            assembleIOSAppDTO(iosSet, "IOS");
        });


        System.out.println("h5 -> " + JSON.toJSONString(h5Set));
        System.out.println("android -> " + JSON.toJSONString(androidSet));
        System.out.println("ios -> " + JSON.toJSONString(iosSet));
        System.out.println("all -> " + JSON.toJSONString(androidSet) + "-----" + JSON.toJSON(iosSet));
    }

    private static void assembleH5AppDTO(Set<String> h5Set, String type)
    {
        //转换H5
        h5Set.add(type);
    }

    private static void assembleIOSAppDTO(Set<String> iosSet, String type)
    {
        iosSet.add(type);
    }

    private static void assembleAndroidAppDTO(Set<String> androidSet, String type)
    {
        androidSet.add(type);
    }
}
