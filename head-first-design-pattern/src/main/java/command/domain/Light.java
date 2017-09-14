package command.domain;

/**
 * Created by macvi on 2017/5/20.
 */
public class Light {

    private String location;

    public Light(String location){
        this.location = location;
    }

    public void on(){
        System.out.println("Light is on");
    }

    public void off(){
        System.out.println("light is off");
    }
}
