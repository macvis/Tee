package subject1;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 写一个邮件查找算法， 可以根据发件人+标题关键字+时间区间
 * 中的任意一个或者几个进行搜索，返回符合查找条件的邮件列表
 *
 * @author youchao.wen
 * @date 2020/4/19.
 */
public class Subject2 {
    public static void main(String[] args) {
        new Subject2().queryByMap("Tom", "jerry", new Timestamp(System.currentTimeMillis()));
    }

    public List<String> queryByMap(String sender, String title, Timestamp timestamp) {
        Map<String, Object> params = new HashMap<>(3);
        params.put("sender", sender);
        params.put("title", title);
        params.put("timestamp", timestamp);

        return query(params);
    }

    public List<String> query(Map<String, Object> params){
        // 大致思路1是查询数据库
        // select column from tb_main
        // where
        //<where>-- 使用mybatis的动态sql包装
        //sender = #{sender}
        //and title like CONCAT('%', #{title}, '%')
        //and create_time >= timestamp
        //and create_time <= timestamp
        // </where>

        //思路2是全量加载到缓存中，去缓存中搜索

        return null;
    }
}
