package iterator.composite.component;

import iterator.composite.component.impl.Menu;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author youchao.wen
 * @date 2017/9/13.
 */
public abstract class MenuComponent {
    public String getName() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public boolean isVegetarian() {
        return false;
    }

    public double getPrice() {
        return -1;
    }

    public void print() {

    }

    public void add(MenuComponent menuComponent){

    }

    public void remove(MenuComponent menuComponent){

    }

    public MenuComponent getChild(int index){
        return null;
    }

    public CompositeIterator createIterator(){
        return null;
    }

    static class CompositeIterator implements Iterator {

        Stack stack = new Stack();

        public CompositeIterator(Iterator iterator){
            stack.push(iterator);
        }

        @Override
        public boolean hasNext() {
            if(stack.empty()){
                return false;
            }

            Iterator iterator = (Iterator) stack.peek();
            if(!iterator.hasNext()){
                stack.pop();
                return hasNext();
            }

            return true;
        }

        @Override
        public Object next() {
            if(!hasNext()){
                return null;
            }

            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            if(component instanceof Menu){
                stack.push(component.createIterator());
            }
            return component;
        }
    }
}
