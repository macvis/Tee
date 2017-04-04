import org.junit.Test;
import week1.homework.linkedList.LinkedList;

/**
 * Created by macvi on 2017/4/3.
 */
public class LinkedListTest {

    @Test
    public void testLinkedListAdd(){
       LinkedList ll = new LinkedList();
       ll.add("123");
       ll.add("456");
       ll.add("asdf");
       ll.add("zxcv");

       System.out.println("ll.toString-->" + ll);
       System.out.println("ll.size--->" + ll.size());
    }

    @Test
    public void testLinkedListIndexAdd(){
        System.out.println("12345");
    }

    @Test
    public void testGet(){
        LinkedList ll = new LinkedList();
        for(int i = 0; i < 10; i ++){
            ll.add(i + "");
        }

        System.out.println("get-->" + ll.get(9));
        System.out.println("ll.toString-->" + ll.toString() + "\nsize-->" + ll.size());
    }

    @Test
    public void testIndexAdd(){
        LinkedList ll = new LinkedList();
        for(int i = 0; i < 5; i ++){
            ll.add(i + "");
        }

        ll.add(5, "xxoo");
        System.out.println("index get-->" + ll.get(0));
        System.out.println("ll.toString2-->" + ll.toString() + "\nsize-->" + ll.size());
    }

    @Test
    public void testRemove(){
        LinkedList ll = new LinkedList();
        for(int i = 0; i < 6; i ++){
            ll.add(i + "");
        }

        Object removed = ll.remove(-1);
        System.out.println("ll.toString-->" + ll.toString() + "\nsize-->" + ll.size());
        System.out.println("removed-->" + removed.toString());
    }
}
