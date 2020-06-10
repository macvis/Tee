package demo;

/**
 * 寻找给定的指定字符串子集，可以乱序
 * 并输出最大长度
 *
 * @author youchao.wen
 * @date 2020/6/9.
 */
public class Subject2 {
    public static int solve(String str) {
        final String str2Check = "aeiouAEIOU";
        int length = 0;

        if(str == null || str.length() == 0){
            return length;
        }

        char[] charArray = str.toCharArray();
        for(char c : charArray){
            if(str2Check.contains(c + "")){

            }
        }

        return -1;
    }
}
