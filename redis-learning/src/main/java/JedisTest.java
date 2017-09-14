import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * @author youchao.wen
 * @date 2017/9/12.
 */
public class JedisTest {
    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);

        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379);
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            jedis.auth("123456");
            jedis.set("name_jedis", "Tee, add by java");
            String value1 = jedis.get("name");
            String value2 = jedis.get("name_jedis");
            System.out.println("value1 -> " + value1);
            System.out.println("value2 -> " + value2);
            Set<String> allKeys = jedis.keys("*");
            System.out.println("all -> " + allKeys);
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }
    }



}
