package iterator.simple.menus;


import iterator.composite.component.impl.MenuItem;
import iterator.simple.Menu;

import java.util.ArrayList;

/**
 * Head First Design迭代器与组合模式的例子
 * page318
 *
 * 对象村煎饼屋
 *
 * Created by Tee on 2017/6/7.
 */
public class PancakeHouseMenu implements Menu {
    static ArrayList<MenuItem> menuItems = new ArrayList();

    static{
        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true, 2.99);

        addItem("Regular Pancake BreakFast",
                "Pancakes with fried eggs, sausage",
                false, 2.99);

        addItem("BlueBerry Pancakes",
                "Pancakes made with fresh blueberries",
                true, 3.49);

        addItem("Waffles",
                "Waffles, with your choise of blueberries or strawberries",
                true, 3.59);
    }

    public PancakeHouseMenu() {}

    public static void addItem(String name, String description, boolean vegetarian, double price){
        menuItems.add(
                new MenuItem(name, description, vegetarian, price)
        );
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }

    public Iterator iterator = new Iterator() {
        ArrayList<MenuItem> items = menuItems;
        int pos = 0;
        @Override
        public boolean hasNext() {
            return pos + 1 <= items.size();
        }

        @Override
        public Object next() {
            MenuItem item = items.get(pos);
            pos ++;
            return item;
        }
    };

    @Override
    public Iterator getIterator() {
        return iterator;
    }
}
