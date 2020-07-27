package subjects;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author youchao.wen
 * @date 2020/7/27.
 */
public class Subject17DialKeysLettersComposition {

    private final static String[] DIAL_LETTERS = new String[]{
            " ", "!@#", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    private static ArrayList<String> res;

    public static List<String> solve(String digits) {

        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    private static void  findCombination(String digits, int index, String s){

        if(index == digits.length()){
            res.add(s);
            return;
        }

        Character c = digits.charAt(index);
        String letters = DIAL_LETTERS[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination(digits, index+1, s + letters.charAt(i));
        }

        return;
    }


    public static void main(String[] args) {
        System.out.println(solve("23"));
    }
}
