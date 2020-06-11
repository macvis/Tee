package subjects;

/**
 * 罗马数字转整数
 *
 *  从字符串末端往前解析，I=1， V=5。。。。
 *
 * @author youchao.wen
 * @date 2020/6/10.
 */
public class Subject13RomeNumber2Integer {
    static final String one = "I";

    static final String four = "IV";
    static final String five = "V";

    static final String nine = "IX";
    static final String ten = "X";

    static final String forty = "XL";
    static final String fifty = "L";

    static final String ninety = "XC";
    static final String hundred = "C";

    static final String forHundred = "CD";
    static final String fiveHundred = "D";

    static final String nineHundred = "CM";
    static final String thousand = "M";
    static int value = 0;
    public static int romanToInt(String romeNumber){

        if(romeNumber == null || "".equals(romeNumber) || romeNumber.length() == 0){
            return value;
        }
        int length = romeNumber.length();
        int lastIndex = length - 1;
        String last2Str = length > 1 ? romeNumber.substring(lastIndex - 1) : "";
        String lastStr = romeNumber.substring(lastIndex);
        if(last2Str.equals(four)){
            value += 4;
            return romanToInt(romeNumber.substring(0, length - 2));
        }else if(last2Str.equals(nine)){
            value += 9;
            return romanToInt(romeNumber.substring(0, length - 2));
        }else if(last2Str.equals(forty)){
            value += 40;
            return romanToInt(romeNumber.substring(0, length - 2));
        }else if(last2Str.equals(ninety)){
            value += 90;
            return romanToInt(romeNumber.substring(0, length - 2));
        }else if(last2Str.equals(forHundred)){
            value += 400;
            return romanToInt(romeNumber.substring(0, length - 2));
        }else if(last2Str.equals(nineHundred)){
            value += 900;
            return romanToInt(romeNumber.substring(0, length - 2));
        }else if(lastStr.equals(one)){
            value += 1;
            return romanToInt(romeNumber.substring(0, length - 1));
        }if(lastStr.equals(five)){
            value += 5;
            return romanToInt(romeNumber.substring(0, length - 1));
        }else if(lastStr.equals(ten)){
            value += 10;
            return romanToInt(romeNumber.substring(0, length - 1));
        }else if(lastStr.equals(fifty)){
            value += 50;
            return romanToInt(romeNumber.substring(0, length - 1));
        }else if(lastStr.equals(hundred)){
            value += 100;
            return romanToInt(romeNumber.substring(0, length - 1));
        }else if(lastStr.equals(fiveHundred)){
            value += 100;
            return romanToInt(romeNumber.substring(0, length - 1));
        }else if(lastStr.equals(thousand)){
            value += 1000;
            return romanToInt(romeNumber.substring(0, length - 1));
        };

        return value;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
