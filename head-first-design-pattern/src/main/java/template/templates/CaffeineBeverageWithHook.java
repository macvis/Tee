package template.templates;

/**
 * Created by Tee on 2017/6/6.
 */
public abstract class CaffeineBeverageWithHook {

    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    public abstract void brew();

    public abstract void addCondiments();

    void boilWater() {
        System.out.println("boiling water");
    }

    void pourInCup() {
        System.out.println("pouring into cup");
    }

    public boolean customerWantsCondiments() {
        return true;
    }
}
