package headFirstDesignPattern.iterator.composite.waitress;

import headFirstDesignPattern.iterator.composite.component.MenuComponent;

import java.util.Iterator;

/**
 * @author youchao.wen
 * @date 2017/9/13.
 */
public class Waitress {
    MenuComponent allMenu;

    public Waitress(MenuComponent allMenu){
        this.allMenu = allMenu;
    }

    public void printMenu(){
        allMenu.print();
    }

    public void printVegetarianMenu(){
        Iterator iterator = allMenu.createIterator();
        System.out.println("====VEGETARIAN MENU====");
        while (iterator.hasNext()){
            MenuComponent component = (MenuComponent)iterator.next();
            if(!component.isVegetarian()){
                continue;
            }
            component.print();
        }
    }
}
