package designPattern;

import headFirstDesignPattern.decorator.Beverage;
import headFirstDesignPattern.decorator.beverages.DarkRoast;
import headFirstDesignPattern.decorator.beverages.Espresso;
import headFirstDesignPattern.decorator.beverages.HouseBlend;
import headFirstDesignPattern.decorator.condiments.Mocha;
import headFirstDesignPattern.decorator.condiments.Soy;
import headFirstDesignPattern.decorator.condiments.Whip;
import org.junit.Test;

/**
 * @author : 温友朝
 * @date : 2017/5/5
 */
public class StarBuzzCoffeeTest {

    @Test
    public void test1(){
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " cost $" + espresso.cost());

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDescription() + " cost $" + darkRoast.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println(houseBlend.getDescription() + " cost $" + houseBlend.cost());
    }
}
