package designPattern;

import headFirstDesignPattern.commandPattern.RemoteControl;
import headFirstDesignPattern.commandPattern.SimpleRemoteControl;
import headFirstDesignPattern.commandPattern.commandImpl.*;
import headFirstDesignPattern.commandPattern.domain.GarageDoor;
import headFirstDesignPattern.commandPattern.domain.Light;
import headFirstDesignPattern.commandPattern.domain.Stereo;
import org.junit.Before;
import org.junit.Test;

/**
 * 命令模式测试类
 * Head First Design C.6
 *
 * Created by Tee.W on 2017/5/20.
 */
public class CommandPatternTest {

    SimpleRemoteControl control;

    RemoteControl remoteControl;

    @Before
    public void init(){
        control = new SimpleRemoteControl();

        remoteControl = new RemoteControl();
    }

    @Test
    public void testLightOn(){

        Light light = new Light("");
        LightOnCommand lightOn = new LightOnCommand(light);

        control.setCommand(lightOn);
        control.pressButton();
    }

    @Test
    public void testGarageDoor(){
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand openCommand = new GarageDoorOpenCommand(garageDoor);

        control.setCommand(openCommand);
        control.pressButton();
    }

    @Test
    public void testRemoteControl() {
        Light livingRoomLight = new Light("living room");
        Light kitchenLight = new Light("kitchen");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo("living room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remoteControl.setCommands(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommands(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommands(2, garageDoorOpen, garageDoorClose);
        remoteControl.setCommands(3, stereoOnWithCD, stereoOff);

        System.out.println(remoteControl);

        remoteControl.pressOn(0);
        remoteControl.pressOff(0);
        remoteControl.pressOn(1);
        remoteControl.pressUndo();
        
        remoteControl.pressOff(1);
        remoteControl.pressOn(2);
        remoteControl.pressOff(2);
        remoteControl.pressOn(3);
        remoteControl.pressOff(3);
    }
}
