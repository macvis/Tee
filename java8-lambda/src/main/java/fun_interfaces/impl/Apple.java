package fun_interfaces.impl;

import fun_interfaces.Fruit;

/**
 * @author youchao.wen
 * @date 2017/8/11.
 */
public class Apple implements Fruit {
    @Override
    public String name() {
        return "apple";
    }

    @Override
    public String color() {
        return "red";
    }

    @Override
    public void weigh(int scale) {
        System.out.println("weigh apple");
    }

} 
