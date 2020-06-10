package subjects;

import org.apache.commons.lang3.StringUtils;

/**
 * 整数转罗马数字
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。
 * 12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * @author youchao.wen
 * @date 2020/6/10.
 */
public class Subject12Transfer2RomeNumbers {
    public static String solve(int number) {
        if (number > 3999 || number < 1) {
            return "无法转换";
        }

        //按位数分解，最多4位
        int kilo = number / 1000;
        int hundred = (number - kilo * 1000) / 100;
        int ten = (number - kilo * 1000 - hundred * 100) / 10;
        int single = number - kilo * 1000 - hundred * 100 - ten * 10;

        //千位不管，不会超过4，对应的M个数即可
        String kiloStr = StringUtils.EMPTY;
        for (int k = 1; k <= kilo; k++) {
            kiloStr = kiloStr.concat("M");
        }

        //百位
        String hundredStr = StringUtils.EMPTY;
        for (int h = 1; h <= hundred; h++) {
            if (h == 4) {
                hundredStr = "CD";
            } else if (h == 5) {
                hundredStr = "D";
            } else if (h == 9) {
                hundredStr = "CM";
            } else {
                hundredStr = hundredStr.concat("C");
            }
        }

        //十位
        String tenStr = StringUtils.EMPTY;
        for (int t = 1; t <= ten; t++) {
            if (t == 4) {
                tenStr = "XL";
            } else if (t == 5) {
                tenStr = "L";
            } else if (t == 9) {
                tenStr = "XC";
            } else {
                tenStr = tenStr.concat("X");
            }
        }

        //个位
        String singleStr = StringUtils.EMPTY;
        for(int s = 1; s <= single; s ++){
            if (s == 4) {
                singleStr = "IV";
            } else if (s == 5) {
                singleStr = "V";
            } else if (s == 9) {
                singleStr = "IX";
            } else {
                singleStr = singleStr.concat("I");
            }
        }

        return kiloStr.concat(hundredStr).concat(tenStr).concat(singleStr);
    }

    public static void main(String[] args) {
        System.out.println(solve(1994));
        System.out.println(10);
    }
}
