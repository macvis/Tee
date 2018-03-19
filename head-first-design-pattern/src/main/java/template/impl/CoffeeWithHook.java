package template.impl;

import template.templates.CaffeineBeverageWithHook;

import java.util.Scanner;

/**
 * Created by Tee on 2017/6/6.
 */
public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    public void brew() {
        System.out.println("dripping coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("adding sugar and milk");
    }

    /**
     * 其实在这个例子中，这个方法可以在父类中定义好，
     * 如果一直是这样的实现的话
     *
     * @return
     */
    public boolean customerWantsCondiments() {
        String answer = "";
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("would you like to add milk and sugar? (y/n)");
            answer = sc.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        return "y".equalsIgnoreCase(answer);
    }
}
