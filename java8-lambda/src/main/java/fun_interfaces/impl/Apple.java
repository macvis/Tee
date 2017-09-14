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


    //    @Override
//    public String weigh(int scale) {
//        this.scale = scale + "";
//        return this.scale;
//    }
//
//    @Override
//    public void eat() {
//        System.out.println("eating apple");
//    }
}
