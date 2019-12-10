package reflect;

/**
 * @author youchao.wen
 * @date 2019/11/30.
 */
public class AppleOfFruitImpl implements Fruit {
    @Override
    public String getName(String prefix) {
        return prefix + "Apple";
    }
}
