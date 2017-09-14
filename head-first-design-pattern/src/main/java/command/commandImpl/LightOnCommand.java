package command.commandImpl;


import command.Command;
import command.domain.Light;

/**
 * Created by macvi on 2017/5/20.
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
