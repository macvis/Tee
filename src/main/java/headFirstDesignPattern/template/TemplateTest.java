package headFirstDesignPattern.template;

import headFirstDesignPattern.template.impl.CoffeeWithHook;
import headFirstDesignPattern.template.impl.Tea;
import org.junit.Test;

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
