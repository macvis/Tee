package subjects;

/**
 * 正则表达式匹配，难度Hard
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author youchao.wen
 * @date 2020/5/30.
 */
public class Subject10MatchRegularExp {

    /**
     * 1. 回溯
     * -  如果没有星号（正则表达式中的 * ），问题会很简单——我们只需要从左到右检查匹配串 s 是否能匹配模式串 p 的每一个字符。
     * 当模式串中有星号时，我们需要检查匹配串 s 中的不同后缀，以判断它们是否能匹配模式串剩余的部分。
     * 一个直观的解法就是用回溯的方法来体现这种关系。
     * -  如果模式串中有星号，它会出现在第二个位置，即 \text{pattern[1]}pattern[1] 。
     * 这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，
     * 即 \text{pattern[0]}pattern[0] 。如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，
     * 匹配串和模式串就可以被匹配。
     *
     */
    private static boolean matchByRecall(String str, String pattern) {
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        boolean firstMatch = (!str.isEmpty() &&
                (pattern.charAt(0) == str.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (matchByRecall(str, pattern.substring(2)) ||
                    (firstMatch && matchByRecall(str.substring(1), pattern)));
        } else {
            return firstMatch && matchByRecall(str.substring(1), pattern.substring(1));
        }
    }

    /**
     * 动态规划
     * 因为题目拥有 最优子结构 ，一个自然的想法是将中间结果保存起来。
     * 我们通过用 \text{dp(i,j)}dp(i,j) 表示 \text{text[i:]}text[i:] 和 \text{pattern[j:]}pattern[j:] 是否能匹配。
     * 我们可以用更短的字符串匹配问题来表示原本的问题。
     *
     * 算法
     * 我们用 [方法 1] 中同样的回溯方法，除此之外，因为函数 match(text[i:], pattern[j:]) 只会被调用一次，
     * 我们用 \text{dp(i, j)}dp(i, j) 来应对剩余相同参数的函数调用，这帮助我们节省了字符串建立操作所需要的时间，
     * 也让我们可以将中间结果进行保存。
     */
    private static boolean matchByDynamicProgram(String str, String pattern){

    }
}
