package headFirstDesignPattern.commandPattern.domain;

/**
 * Created by Tee.W on 2017/5/20.
 */
public class Stereo {

    private String location;
    private int volume;

    public Stereo(String location){
        this.location = location;
    }

    public void on(){
        System.out.println("stereo is on");
    }

    public void setCD(){
        System.out.println("stereo's CD set up");
    }

    public void setVolume(int volume){
        this.volume = volume;
        System.out.println("stereo's volume is " + volume);
    }

    public void off(){
        System.out.println("stereo off");
    }
}
