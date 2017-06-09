package headFirstDesignPattern.iterator;

import headFirstDesignPattern.iterator.items.DinnerMenu;
import headFirstDesignPattern.iterator.items.PancakeHouseMenu;

/**
 * The waitress
 *
 * Created by Tee on 2017/6/7.
 */
public class Alice {
    static Menu[] menus = new Menu[]{new PancakeHouseMenu(), new DinnerMenu()};
    /**
     * 打印菜单上的每一项
     */
    public static void printMenu(){
        for(Menu menu : menus){
            Iterator iter = menu.getIterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        }
    }

    /**
     * 只打印早餐项
     */
    public void printBreakFastMenu(){

    }

    /**
     * 只打印午餐项
     */
    public void printLunchMenu(){

    }

    /**
     * 打印所有的素食菜单项
     */
    public void printVegetarianMenu(){

    }

    /**
     * 是否素食
     */
    public boolean isItemVegetarian(String name){
        return true;
    }
}
