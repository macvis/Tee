package adaptor.adaptor;

import adaptor.IDuck;
import adaptor.ITurkey;

/**
 * Created by Tee on 2017/6/1.
 */
public class TurkeyAdaptor implements IDuck {
    ITurkey turkey;

    public TurkeyAdaptor(ITurkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        //火鸡飞行距离比较短，要飞5次才能达到鸭子的同等距离
        for(int i = 0; i < 5; i++){
            turkey.fly();
        }
    }
}
