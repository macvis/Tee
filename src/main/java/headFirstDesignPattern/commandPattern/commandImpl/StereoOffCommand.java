package headFirstDesignPattern.commandPattern.commandImpl;

import headFirstDesignPattern.commandPattern.Command;
import headFirstDesignPattern.commandPattern.domain.Stereo;

/**
 * Created by Tee.W on 2017/5/20.
 */
public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo){
        this.stereo = stereo;
    }

    public void execute() {
        stereo.off();
    }

    public void undo() {
        stereo.on();
    }
}