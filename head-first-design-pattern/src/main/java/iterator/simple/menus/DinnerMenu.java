package iterator.simple.menus;

import iterator.composite.component.impl.MenuItem;
import iterator.simple.Menu;

/**
 * Head First Design迭代器与组合模式的例子
 * page319
 *
 * 对象村餐厅
 *
 *
 * Created by Tee on 2017/6/7.
 */
public class DinnerMenu implements Menu {
    static final int MAX_ITEMS = 6;

    static int numberOfItems = 0;
    static MenuItem[] menuItems = new MenuItem[MAX_ITEMS];;

    static{
        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true, 2.99);

        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat",
                false, 2.99);

        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false, 3.29);

        addItem("Hot dog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false, 3.05);
    }

    public DinnerMenu(){}

    public static void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS){
            System.err.println("Sorry, menu if full. Add item to menu canceled");
        }else{
            menuItems[numberOfItems] = menuItem;
            numberOfItems ++;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public Menu.Iterator iterator = new Iterator() {
        MenuItem[] items = menuItems;
        int position = 0;

        @Override
        public boolean hasNext() {
            return position + 1 <= items.length && items[position] != null;
        }

        @Override
        public Object next() {
            MenuItem item = items[position];
            position++;
            return item;
        }
    };

    @Override
    public Menu.Iterator getIterator() {
        return iterator;
    }
}
