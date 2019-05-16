package demoPack;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Tee on 2017/5/27.
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        String pattern = "yyyy-MM-dd";
        int in1 = compareDate("2017-05-02",
                "2017-05-26 11:23:23", pattern);

        int in2 = compareDate("2018-05-02",
                "2017-05-26", pattern);

        int in3 = compareDate("2017-05-26",
                "2017-05-26", pattern);

        int in4 = compareDate("2017-05-26",
                "2017-05-26", pattern);

        int in5 = compareDate("2017-05-26 14:12:11", "", pattern);

//        System.out.println("in1 -> " + in1);
//        System.out.println("in2 -> " + in2);
//        System.out.println("in3 -> " + in3);
//        System.out.println("in4 -> " + in4);
//        System.out.println("in5 -> " + in5);


        System.out.println("check digit -> " + checkDigit("-2000"));
    }

    /**
     * 比较日期
     *
     * @param date1Str
     * @param date2Str
     * @param pattern
     * @return 1  - date1 > date2
     * -1  - date1 < date2
     * 0  - date1 = date2
     * -2  - 异常，无法比较
     */
    public static int compareDate(String date1Str, String date2Str, String pattern) {
        if (StringUtils.isBlank(date1Str) |
                StringUtils.isBlank(date2Str) |
                StringUtils.isBlank(pattern)) {
            return -2;
        }
        Date date1 = strToDate(date1Str, pattern);
        Date date2 = strToDate(date2Str, pattern);
        return date1.compareTo(date2);
    }

    /**
     * 根据par时间格式化转化为date日期
     *
     * @param str
     * @param par
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str, String par) {
        if (null == str || null == par) {
            return null;
        }
        DateFormat format = new SimpleDateFormat(par);
        try {
            return format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean checkDigit(String digit) {
        String regex = "^0|(-|\\+)?[1-9]\\d*$";
        return Pattern.matches(regex, digit);
    }
}
