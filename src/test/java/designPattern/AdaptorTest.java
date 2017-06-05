package designPattern;

import headFirstDesignPattern.adaptor.IDuck;
import headFirstDesignPattern.adaptor.adaptor.TurkeyAdaptor;
import headFirstDesignPattern.adaptor.impl.MallardDuck;
import headFirstDesignPattern.adaptor.impl.WildTurkey;

/**
 * Created by Tee on 2017/6/2.
 */
public class AdaptorTest {
    public static void main(String[] args){
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        IDuck turkeyAdaptor = new TurkeyAdaptor(turkey);

        System.out.println("the turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\n");
        System.out.println("the duck says...");
        testDuck(duck);

        System.out.println("\n");
        System.out.println("the turkey adaptor says...");
        testDuck(turkeyAdaptor);
    }

    //这是我们的testDuck()方法，取得一只鸭子
    //并调用它的quack()和fly()方法
    private static void testDuck(IDuck duck){
        duck.quack();
        duck.fly();
    }
}
