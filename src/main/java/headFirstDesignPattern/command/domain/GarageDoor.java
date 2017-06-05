package headFirstDesignPattern.command.domain;

/**
 * Created by Tee.W on 2017/5/20.
 */
public class GarageDoor {


    public void up(){
        System.out.println("Garage door is open");
    }

    public void down(){
        System.out.println("garage door's down()");
    }

    public void stop(){
        System.out.println("garage door's stop");
    }

    public void lightOn(){
        System.out.println("garage door's light on");
    }

    public void lightOff(){
        System.out.println("garage door's light off");
    }
}
