package iterator.simple.menus;

import iterator.composite.component.impl.MenuItem;
import iterator.simple.Menu;

import java.util.HashMap;

/**
 * @author youchao.wen
 * @date 2017/9/13.
 */
public class CafeMenu implements Menu {

    HashMap<String, MenuItem> menuItems;

    public HashMap<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        menuItems.put(name, new MenuItem(name, description, vegetarian, price));
    }

    @Override
    public Iterator getIterator() {
        Iterator iter = new Iterator() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };

        return iter;
    }
}
