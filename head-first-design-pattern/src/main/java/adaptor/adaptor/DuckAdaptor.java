package adaptor.adaptor;

import adaptor.IDuck;
import adaptor.ITurkey;

/**
 * 火鸡适配器
 * -> 假装自己是鸭的火鸡
 *
 * Created by Tee on 2017/6/2.
 */
public class DuckAdaptor implements ITurkey {
    IDuck duck;

    public DuckAdaptor(IDuck duck){
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        System.out.println("i'm flew a short distance");
    }
}
