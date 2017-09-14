package template;


import org.junit.Test;
import template.impl.CoffeeWithHook;
import template.impl.Tea;

/**
 * Created by Tee on 2017/6/6.
 */
public class TemplateTest {

    @Test
    public void makeTea(){
        Tea myTea = new Tea();
        System.out.println("making tea:");
        myTea.prepareRecipe();
    }

    @Test
    public void makeBeverage(){
        CoffeeWithHook coffee = new CoffeeWithHook();
        System.out.println("making coffee...");
        coffee.prepareRecipe();
    }

    public static void main(String[] args){
        CoffeeWithHook coffee = new CoffeeWithHook();
        System.out.println("making coffee...");
        coffee.prepareRecipe();
    }
}
