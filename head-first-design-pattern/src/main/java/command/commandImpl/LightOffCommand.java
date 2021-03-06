package command.commandImpl;


import command.Command;
import command.domain.Light;

/**
 * Created by Tee.W on 2017/5/20.
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}
