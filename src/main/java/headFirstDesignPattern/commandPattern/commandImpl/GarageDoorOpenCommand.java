package headFirstDesignPattern.commandPattern.commandImpl;

import headFirstDesignPattern.commandPattern.Command;
import headFirstDesignPattern.commandPattern.domain.GarageDoor;

/**
 * Created by Tee.W on 2017/5/20.
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.up();
    }

    public void undo() {
        garageDoor.down();
    }
}
