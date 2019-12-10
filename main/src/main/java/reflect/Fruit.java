package reflect;

/**
 * @author youchao.wen
 * @date 2019/11/30.
 */
public interface Fruit {
    String getName(String prefix);

    default String getDescription() {
        return "I'm fruit";
    }
}
