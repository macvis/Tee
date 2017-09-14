package command;

/**
 * 命令模式 - command接口
 *
 * Created by macvi on 2017/5/20.
 */
public interface Command {
    void execute();

    void undo();
}
