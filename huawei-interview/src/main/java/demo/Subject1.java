package demo;


/**
 * 集五福
 * 如输入，10001, 11011, 111011 => 该团队无法集齐五福
 *
 * @author youchao.wen
 * @date 2020/6/9.
 */
public class Subject1 {
    public static boolean solve(String strs) {
        if (strs == null) {
            return false;
        }
        //每个位置出现1的次数的统计
        int[] indexCounts = new int[5];
        String[] strArray = strs.split(",");

        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            //每个元素是定长的，长度=5
            if (str.length() != 5) {
                return false;
            }
            //每个字符仅包含0或1
            if (!str.contains("0") || !str.contains("1")) {
                return false;
            }

            char[] chars = str.toCharArray();
            for (int j = 0; j < 5; j++) {
                if (chars[j] == '1') {
                    indexCounts[j] = 1;
                }
            }
        }

        int sum = 0;
        for(int count : indexCounts){
            sum += count;
        }
        return sum >= 5;
    }

    public static void main(String[] args) {
        System.out.println(solve("222222,10000,01000,01111"));
        System.out.println(solve(null));

    }
}
