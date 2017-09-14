package iterator.composite.component.impl;

import iterator.composite.component.MenuComponent;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author youchao.wen
 * @date 2017/9/13.
 */
public class Menu extends MenuComponent {
    ArrayList menuComponents = new ArrayList();
    String name;
    String description;

    public Menu(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent){
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int index){
        return (MenuComponent) menuComponents.get(index);
    }

    public ArrayList getMenuComponents() {
        return menuComponents;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void print(){
        System.out.println("class       -> " + Menu.class.getName());
        System.out.println("name        -> " + name);
        System.out.println("description -> " + description);
        if(menuComponents.size() > 0){
            System.out.println("-----------------------------");
            System.out.println("iterating sub menu");
            System.out.println("-----------------------------");
            Iterator ite = menuComponents.iterator();
            while(ite.hasNext()){
                MenuComponent mc = (MenuComponent) ite.next();
                mc.print();
            }
        }
    }
}
