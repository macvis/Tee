package headFirstDesignPattern.command;

/**
 * Created by macvi on 2017/5/20.
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(){}

    public void setCommand(Command cmd){
        this.slot = cmd;
    }

    public void pressButton(){
        this.slot.execute();
    }
}
