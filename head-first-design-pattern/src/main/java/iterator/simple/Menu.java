package iterator.simple;

/**
 * Created by Tee on 2017/6/7.
 */
public interface Menu {
    Iterator getIterator();

    interface Iterator {
        boolean hasNext();

        Object next();
    }
}
