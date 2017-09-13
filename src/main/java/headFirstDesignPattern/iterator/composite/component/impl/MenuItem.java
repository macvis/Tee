package headFirstDesignPattern.iterator.composite.component.impl;

import headFirstDesignPattern.iterator.composite.component.MenuComponent;

/**
 * @author youchao.wen
 * @date 2017/9/13.
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void print(){
        System.out.println("class       -> " + MenuItem.class.getName());
        System.out.println("name        -> " + name);
        System.out.println("vegetarian? -> " + vegetarian);
        System.out.println("price       -> " + price);
        System.out.println("description -> " + description);
        System.out.println("-----------------------------");
    }
}
