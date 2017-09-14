package command.commandImpl;


import command.Command;
import command.domain.GarageDoor;

/**
 * Created by Tee.W on 2017/5/20.
 */
public class GarageDoorCloseCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.down();
    }

    public void undo() {
        garageDoor.up();
    }
}
