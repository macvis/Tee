package subjects;

import org.apache.commons.lang3.StringUtils;

/**
 * 最长通用前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明: 所有输入只包含小写字母 a-z 。
 *
 * @author youchao.wen
 * @date 2020/6/10.
 */
public class Subject14LongestCommonPrefix {
    private static String solve(String[] strArray) {
        if (strArray == null || strArray.length <= 0) {
            return StringUtils.EMPTY;
        }
        int arraySize = strArray.length;
        String commonPrefix = strArray[0];
        for (int i = 0; i < arraySize - 1; i++) {
            commonPrefix = findCommonPrefix(commonPrefix, strArray[i + 1]);
            if (StringUtils.EMPTY.equals(commonPrefix)) {
                return commonPrefix;
            }
        }

        return commonPrefix;
    }

    private static String findCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        StringBuilder prefixTemp = new StringBuilder();
        if (str1.equals(str2)) {
            return str1;
        }

        if ("".equals(str1)
                || "".equals(str2)
                || str1.charAt(0) != str2.charAt(0)) {
            return "";
        }
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                prefixTemp.append(str1.charAt(i));
            }
        }

        return prefixTemp.toString();
    }

    public static void main(String[] args) {
//        System.out.println(solve(new String[]{"flower","flow","flight"}));
//        System.out.println(solve(new String[]{"dog","racecar","car"}));
//        System.out.println(solve(new String[]{"dog","racecar","car"}));
        System.out.println(solve(new String[]{"", "b"}));
//        System.out.println(solve(new String[]{}));
//        System.out.println(solve(new String[]{"aca","cba"}));
    }
}