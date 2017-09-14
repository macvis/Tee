package headFirstDesignPattern.adaptor.adaptor;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by Tee on 2017/6/2.
 */
public class EnumerationIterator implements Iterator {
    Enumeration enumer;

    public EnumerationIterator(Enumeration enumer){
        this.enumer = enumer;
    }

    @Override
    public boolean hasNext() {
        return enumer.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumer.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        throw new UnsupportedOperationException();
    }
}
