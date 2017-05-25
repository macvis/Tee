package demoPack;

/**
 * Created by Tee on 2017/5/25.
 */
public class Foo {

    public static void main(String[] args){
        char c1 = 0x2d4e;
        char c2 = 0x8765;

        char[] arr = new char[]{c1, c2};
        String s = new String(arr);
        System.out.println("s -> " + s);

    }

    private void out(){
        Goo g = new Goo() {};
    }

    abstract class Goo{
        protected abstract void Hoo();

        protected String s1;
        protected String s2;

        public Goo(){

        }

        protected void write(){
            System.out.println("xxoo");
        }
    }


}
