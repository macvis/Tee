package demoPack;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author youchao.wen
 * @date 2020/1/6.
 */
@Data
@Accessors(chain = true)
public class TestChainAccessors {
    private String name;
    private String id;
    private String gender;
    private String soft;

    public static void main(String[] args) {
        TestChainAccessors accessor = new TestChainAccessors().setGender("male").setId("1123").setName("Tom").setSoft("soft");
        System.out.println("JSON -> " + JSON.toJSONString(accessor));
    }
}
