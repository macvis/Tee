package headFirstDesignPattern.commandPattern.commandImpl;

import headFirstDesignPattern.commandPattern.Command;
import headFirstDesignPattern.commandPattern.domain.Stereo;

/**
 * Created by Tee.W on 2017/5/20.
 */
public class StereoOnWithCDCommand implements Command {

    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo){
        this.stereo = stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(10);
    }

    public void undo() {
        stereo.off();
    }
}
