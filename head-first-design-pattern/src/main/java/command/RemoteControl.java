package command;

/**
 * Created by Tee.W on 2017/5/20.
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
    }

    public void setCommands(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void pressOn(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void pressOff(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void pressUndo() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------ Remote Control ------" + "\n");
        for (int i = 0; i < onCommands.length; i++) {
            Command on = onCommands[i];
            if (on == null) {
                continue;
            }

            sb.append("slot = " + i + " [onCommand] -> " + on.getClass().getName() + ", [offCommand] -> "
                    + offCommands[i].getClass().getName() + "\n");
        }

        return sb.toString();
    }
}
