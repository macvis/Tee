package reflect;

/**
 * @author youchao.wen
 * @date 2019/11/30.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
//        Class clazz = Class.forName("reflect.AppleOfFruitImpl");
//        AppleOfFruitImpl apple = (AppleOfFruitImpl)clazz.newInstance();
//        Method method1 = clazz.getDeclaredMethod("getName", String.class);
//        String result1 = (String)method1.invoke(apple, "I'm ");
//        System.out.println(result1);
//
//        Method method2 = clazz.getDeclaredMethod("getDescription");
//        String result2 = (String)method2.invoke(apple);
//        System.out.println(result2);


        System.out.println("DemoClassLoader.parent=" + DemoClassLoader.class.getClassLoader().getParent());
        System.out.println("ExtClassLoader.parent=" + DemoClassLoader.class.getClassLoader().getParent().getParent());
    }


    static class DemoClassLoader extends ClassLoader {

    }
}
