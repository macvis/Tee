package template;

/**
 * 模板方法类，一个概览性质的说明类
 * <p>
 * Created by Tee on 2017/6/6.
 */
public abstract class AbstractClass {
    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    abstract void primitiveOperation1();

    abstract void primitiveOperation2();

    final void concreteOperation() {
        //do something
    }

    /**
     * 这是一个默认不做事的方法。
     * 子类可以选择不覆盖它们
     */
    void hook() {
    }
}
