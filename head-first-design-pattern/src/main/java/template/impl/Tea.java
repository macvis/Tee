package template.impl;


import template.templates.CaffeineBeverage;

/**
 * Created by Tee on 2017/6/5.
 */
public class Tea extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("adding lemon");
    }
}
