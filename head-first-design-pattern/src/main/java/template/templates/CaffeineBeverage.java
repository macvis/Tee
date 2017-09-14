package headFirstDesignPattern.template.templates;

/**
 * 抽象出的咖啡因类饮料方法，供子类实现
 * 其中包含泡茶喝冲调咖啡用的共同的boilingWater煮水和pourInCup倒进杯子方法
 *
 * 以及咖啡因类饮料的模板方法prepareRecipe方法
 *
 * Created by Tee on 2017/6/5.
 */
public abstract class CaffeineBeverage {
    /**
     * 准备饮料，封装好准备的过程
     *
     * 之所以声明为final，是因为不希望子类覆盖这个方法
     *
     * 这是CaffeineBeverage的模板方法：
     * 1) 毕竟它是一个方法
     * 2）它作用一个算法的模板，在这个例子中，算法是用来制作咖啡因饮料的
     * 3）在这个模板中，算法内的每一个步骤都被一个方法代表了
     * 4）某些方法则是由子类处理的
     */
    public final void prepareRecipe(){
        boilingWater();
        brew();
        pourInCup();
        addCondiments();
    }

    /**
     * 冲泡茶/冲调咖啡
     *
     * 因为咖啡喝茶的冲调(冲泡)方法并不同，所以这两个方法
     * 必须被声明为抽象，剩余的实现让子类去做
     */
    protected abstract void brew();

    /**
     * 加料
     * 茶 - 加柠檬，加牛奶
     * 咖啡 - 加牛奶，加方糖
     *
     * 同brew(), 实现交由子类实现
     */
    protected abstract void addCondiments();

    /**
     * 煮水
     */
    void boilingWater(){
        System.out.println("boiling water");
    }

    /**
     * 倒进杯子
     */
    void pourInCup(){
        System.out.println("pouring into cup");
    }
}
