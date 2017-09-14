package headFirstDesignPattern.template.impl;

import headFirstDesignPattern.template.templates.CaffeineBeverage;

/**
 * Created by Tee on 2017/6/5.
 */
public class Coffee extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("adding sugar and milk");
    }
}
