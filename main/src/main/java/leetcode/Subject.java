package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * leet code 刷题、解题
 *
 * @author youchao.wen
 * @date 2019-05-15.
 */
public class Subject {
    /**
     * 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public static class TwoSums1 {

        public static int[] solve1(int nums[], int target) {
            //1. 暴力破解法
            int result[] = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }

            return null;
        }

        public static int[] solve2(int nums[], int target) {
            //2. 使用map
            Map<Integer, Integer> map = new HashMap<>(16);
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                map.putIfAbsent(nums[i], i);
                int remain = target - nums[i];
                if (map.containsKey(remain)) {
                    result[0] = map.get(remain);
                    result[1] = i;
                }
            }
            System.out.println("map -> " + map);

            return result;
        }

        public static void main(String[] args) {
            int[] nums = {2, 7, 11, 15, 0, 20, 21};
            int target = 41;
            int[] result1 = TwoSums1.solve1(nums, target);
            System.out.println("result1 -> " + result1[0] + ", " + result1[1]);

            int[] result2 = TwoSums1.solve2(nums, target);
            System.out.println("result2 -> " + result2[0] + ", " + result2[1]);
        }
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static class TwoSums2 {
        public static ListNode solve1(ListNode node1, ListNode node2) {
            Integer val1 = Integer.parseInt(stringify(node1));
            Integer val2 = Integer.parseInt(stringify(node2));

            int sum = val1 + val2;
            return toNode(sum);
        }

        private static String stringify(ListNode node) {
            StringBuilder val = new StringBuilder();
            ListNode temp = node;
            while (temp != null) {
                val.append(temp.val);
                temp = temp.next;
            }
            return val.reverse().toString();
        }

        public static ListNode toNode(int val) {
            String str = new StringBuilder(val + "").reverse().toString();
            List<String> strList = IntStream
                    .range(0, str.length())
                    .mapToObj(i -> str.substring(i, i + 1))
                    .collect(Collectors.toList());
            ListNode node = new ListNode(Integer.parseInt(strList.get(0)));
            ListNode tmp = node;

            for (int i = 1; i < strList.size(); i++) {
                tmp.add(Integer.parseInt(strList.get(i)));
                tmp = tmp.next;
            }
            return node;
        }

        private static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }

            void add(int x) {
                this.next = new ListNode(x);
            }

            @Override
            public String toString() {
                ListNode node = this;
                StringBuilder builder = new StringBuilder(this.val + "");
                while (node.next != null) {
                    node = node.next;
                    builder.append(" -> ").append(node.val);
                }

                return builder.toString();
            }
        }

        public static void main(String[] args) {

            ListNode node1 = new ListNode(8);
            node1.next = new ListNode(9);
            node1.next.next = new ListNode(4);

            ListNode node2 = new ListNode(6);
            node2.next = new ListNode(1);
            node2.next.next = new ListNode(8);

            ListNode res = TwoSums2.solve1(node1, node2);
            System.out.println("node -> " + res);
        }
    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public static class NonRepeatSubStringLength {
        public static int solve(String str) {
            String noneRepeatStr = "";
            int length = str.length();
            for (int i = 0; i < length; i++) {
                for (int j = length; j >= i; j--) {
                    String temp = str.substring(i, j);
                    if (noneRepeat(temp) && temp.length() > noneRepeatStr.length()) noneRepeatStr = temp;
                }
            }
            return noneRepeatStr.length();
        }

        public static int solve2(String s) {
            // 字符上次出现的位置
            Map<Character, Integer> charLastPos = new HashMap<Character, Integer>(16);
            // 子串起始位置为start+1
            int start = -1;
            // 最长子串长度
            int maxLen = 0;
            // 记录字符串长度，避免for循环多次都调用函数
            int len = s.length();
            for (int i = 0; i < len; i++) {
                Character cur = s.charAt(i);
                if (charLastPos.containsKey(cur)) {
                    // 当前字符上一次出现的位置
                    int lastPos = charLastPos.get(cur);
                    // 出现重复字符时，比较字符上次出现的位置与当前子串start大小
                    // 若小于start，说明不在当前子串里，start不变
                    // 若大于start，说明在当前子串里，把start更新到字符上次出现的位置
                    if (lastPos > start) {
                        start = lastPos;
                    }
                }
                // 子串其实是从start+1位置开始
                // 子串长度计算公式为：i-(start+1)+1，简化为i-start
                int curLen = i - start;
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                charLastPos.put(s.charAt(i), i);
            }
            return maxLen;
        }

        public static boolean noneRepeat(String str) {
            char[] chars = str.toCharArray();

            return false;
        }

        public static void main(String[] args) {
            int res = solve2("pvfnhzjtceavpzjzhwdbgjdehelnuwvlrababkwdowbexmffjigrsjvbpiqmglxaoyaplwtzvwfuimz");
            System.out.println("res -> " + res);
        }
    }

    /**
     * 寻找两个有序数组的中位数
     * <p>
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     */
    public static class FindMedianInSortedArrays {

        public static float solve(int[] nums1, int[] nums2) {
            int totalLength = nums1.length + nums2.length;
            int[] numsArr = new int[totalLength];
            System.arraycopy(nums1, 0, numsArr, 0, nums1.length);

            System.arraycopy(nums2, 0, numsArr, nums1.length, nums2.length);

            Arrays.sort(numsArr);
            System.out.println("numsArr -> " + Arrays.toString(numsArr));

            int medianMod = totalLength % 2;

            float result = 0;
            if (medianMod == 0) {
                int lowerIndex = totalLength / 2 - 1;
                int upperIndex = totalLength / 2;

                result = (float) (numsArr[lowerIndex] + numsArr[upperIndex]) / 2;
            } else {
                int medianIndex = totalLength / 2;
                result = numsArr[medianIndex];
            }

            return result;
        }


        public static void main(String[] args) {
            int[] nums1 = {1, 3, 5, 6};
            int[] nums2 = {2};
            double result = solve(nums1, nums2);
            System.out.println("result -> " + result);
        }
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    public static class LongestPalindrome {
        private static String s1 = "babad";
        private static String s2 = "xcvabbazxca";
        private static String s3 = "hellolleh";
        private static String s4 = "ioklabcddcbalkoasddadsa";

        public static void main(String[] args) {
            System.out.println("subLength1 -> " + solve(s1));
            System.out.println("subLength2 -> " + solve(s2));
            System.out.println("subLength3 -> " + solve(s3));
            System.out.println("subLength4 -> " + solve(s4));
        }

        public static String solve(String str) {
            if (str == null || str.length() == 0) return "";
            if (str.equals(new StringBuilder(str).reverse().toString())) return str;

            int length = str.length();
            String temp = str.substring(0, 1);
            for (int i = 0; i < length; i++) {
                char head = str.charAt(i);
                int tailIndex = str.lastIndexOf(head);
                if (tailIndex <= 0) continue;

                String subStr = str.substring(i, tailIndex + 1);
                String reversed = new StringBuilder(subStr).reverse().toString();
                if (subStr.length() <= 0) continue;
                if (subStr.length() == 1) {
                    temp = subStr;
                    continue;
                }

                if (subStr.equals(reversed)) return subStr;

                subStr = subStr.substring(0, subStr.length() - 1);
                return solve(subStr);
            }

            return temp;
        }
    }

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static class ZStringTransform {
        private static String s1 = "helloworldasthebestdayofyourlife";

        public static String solve(String str, int rows) {
            if (rows <= 1) {
                return str;
            }

            //方向控制法
            //rows=2, ⬇⬆⬇⬆
            //rows=3, ⬇⬇⬆⬆
            String result = "";
            String[] strRows = new String[rows];
            //初始化为空串
            Arrays.fill(strRows, "");
            int length = str.length();
            int rowIndex = 0;
            //字符画前进方向是否向下
            boolean isDown = false;
            for (int i = 0; i < length; i++) {
                String s = str.substring(i, i + 1);
                strRows[rowIndex] += s;
                if (rowIndex == 0) isDown = true;
                if (rowIndex == rows - 1) isDown = false;

                rowIndex = isDown ? rowIndex + 1 : rowIndex - 1;
            }

            for (String s : strRows) {
                result = result.concat(s);
            }

            return result;
        }

        public static void main(String[] args) {
            System.out.println(solve(s1, 4));
        }
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 输入: 123
     * 输出: 321
     * <p>
     * 输入: -123
     * 输出: -321
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意: 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */
    public static class IntegerReverse {
        public static int solve(int num) {
            //数字串String化
            String numStr = num + "";
            String result = "";

            long resultNum = 0L;
            if (num >= 0) {
                result = new StringBuilder(numStr).reverse().toString();
                resultNum = Long.parseLong(result);
            } else {
                String nums = numStr.substring(1, numStr.length());
                result = new StringBuilder(nums).reverse().toString();
                result = "-" + result;
                resultNum = Long.parseLong(result);
            }

            return resultNum > Integer.MAX_VALUE || resultNum < Integer.MIN_VALUE ? 0 : new Long(resultNum).intValue();
        }

        public static void main(String[] args) {
            int re1 = solve(2147483647);
            System.out.println("re1 ->" + re1);

            int re2 = solve(-2147483648);
            System.out.println("re2 ->" + re2);
        }
    }

    /**
     * ----> 这题没有意义
     * <p>
     * <p>
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * <p>
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * <p>
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * <p>
     * 说明：
     * <p>
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     * <p>
     * <p>
     * 输入: "42"
     * 输出: 42
     * <p>
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * <p>
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static class String2Integer {
        static final List<String> numStrList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        static final List<String> effectiveNumStrs = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

        public static int solve(String words) {
            if (words == null || "".equals(words) || "+".equals(words) || "-".equals(words)) {
                return 0;
            }
            int length = words.length();
            words = words.trim();
            if ("".equals(words)) {
                return 0;
            }

            //正负号
            String first = words.substring(0, 1);
            final List<String> possibleBegin = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-");
            if (!possibleBegin.contains(first)) {
                return 0;
            }
            if (("+".equals(first) || "-".equals(first)) && words.length() >= 2) {
                String second = words.substring(1, 2);
                if (!numStrList.contains(second)) return 0;
            }
            String numStr = "";
            if (first.equals("+") || first.equals("-")) {
                String symbolRemoved = words.substring(1, words.length());
                numStr = first + getContinuousNumStr(symbolRemoved, 0, new StringBuilder()).toString();
            } else {
                numStr = getContinuousNumStr(words, 0, new StringBuilder()).toString();
            }

            //头部去零
            while (numStr.startsWith("0") || numStr.startsWith("+") || numStr.startsWith("-")) {
                numStr = numStr.replaceFirst("0", "");
                if ("".equals(numStr)) {
                    return 0;
                }
                if (possibleBegin.contains(numStr.substring(0, 1))
                        && (numStr.length() >= 2 && effectiveNumStrs.contains(numStr.substring(1, 2)))) {
                    break;
                }
            }

            if (first.equals("-") && numStr.length() >= (Integer.MIN_VALUE + "").length()) {
                return Integer.MIN_VALUE;
            }

            if (first.equals("+") && numStr.length() >= (Integer.MAX_VALUE + "").length()) {
                return Integer.MAX_VALUE;
            }

            if (numStr.length() >= (Integer.MAX_VALUE + "").length()) {
                return Integer.MAX_VALUE;
            }

            if (numStr == null || "".equals(numStr) || "+".equals(numStr) || "-".equals(numStr)) {
                return 0;
            }
            Long num = Long.valueOf(numStr);
            if (num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }


            return num.intValue();
        }

        public static StringBuilder getContinuousNumStr(String words, int index, StringBuilder nums) {
            if (words.length() >= (index + 1) && numStrList.contains(words.substring(index, index + 1))) {
                nums.append(words.substring(index, index + 1));
                getContinuousNumStr(words, index += 1, nums);
            }
            return nums;
        }

        public static void main(String[] args) {
            System.out.println("solve -> " + solve("words001122"));
            System.out.println("solve -> " + solve("-001122"));
            System.out.println("solve -> " + solve("+001122"));
            System.out.println("solve -> " + solve(""));
            System.out.println("solve -> " + solve("+"));
            System.out.println("solve -> " + solve("-"));
            System.out.println("solve -> " + solve("+1"));
            System.out.println("solve -> " + solve("-000000000000000000000000000000000000000000000000001"));
            System.out.println("solve -> " + solve("000000000000000000000000000011"));
            System.out.println("solve -> " + solve("+-1"));
            System.out.println("solve -> " + solve("223"));
            System.out.println("solve -> " + solve("3.14"));
            System.out.println("solve -> " + solve("  0000000000012345678"));
            System.out.println("solve -> " + solve("010"));
            System.out.println("solve -> " + solve("-000000000000001"));
            System.out.println("solve -> " + solve("    0000000000000   "));
        }
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 输入: 121
     * 输出: true
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * 你能不将整数转为字符串来解决这个问题吗？
     */
    public static class ConvertPalindrome {
        public static boolean isPalindrome(int num) {
            int temp = 0;
            int sum = 0;
            temp = num;
            while (temp > 0){
                sum = sum * 10 + temp % 10;
                temp = temp / 10;
            }

            return sum == num;
        }

        public static void main(String[] args) {
            System.out.println("solve -> " + isPalindrome(131));
            System.out.println("solve -> " + isPalindrome(222));
            System.out.println("solve -> " + isPalindrome(12345));
            System.out.println("solve -> " + isPalindrome(199991));
            System.out.println("solve -> " + isPalindrome(11));
            System.out.println("solve -> " + isPalindrome(-56765));
        }
    }
}
