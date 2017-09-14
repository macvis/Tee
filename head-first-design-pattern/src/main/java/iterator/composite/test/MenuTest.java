package iterator.composite.test;

import iterator.composite.component.MenuComponent;
import iterator.composite.component.impl.Menu;
import iterator.composite.component.impl.MenuItem;
import iterator.composite.waitress.Waitress;

/**
 * @author youchao.wen
 * @date 2017/9/13.
 */
public class MenuTest {
    public static void main(String[] args){
        MenuComponent pancakeHouse = new Menu("PANCAKE HOUSE MENU", "BreakFast");
        MenuComponent dinner = new Menu("DINNER HOUSE MENU", "Lunch");
        MenuComponent cafe = new Menu("CAFE HOUSE MENU", "Dinner");
        MenuComponent dessert = new Menu("DESSERT HOUSE MENU", "Dessert of Course");

        MenuComponent allMenu = new Menu("ALL MENUS", "All menus combined");
        allMenu.add(pancakeHouse);
        allMenu.add(cafe);
        allMenu.add(dinner);

        dinner.add(new MenuItem("Paste", "Spaghetti with Marinara Sauce", true, 3.89));
        dinner.add(dessert);
        dessert.add(new MenuItem("Apple pie", "Apple pie with a flakey crust", true, 1.59));

        Waitress waitress = new Waitress(allMenu);
        waitress.printMenu();
    }
}
