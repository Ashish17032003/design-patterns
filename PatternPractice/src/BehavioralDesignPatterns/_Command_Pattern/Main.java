package BehavioralDesignPatterns._Command_Pattern;

import BehavioralDesignPatterns._Command_Pattern._Concrete_Command.AdjustVolumeCommand;
import BehavioralDesignPatterns._Command_Pattern._Concrete_Command.ChangeChannelCommand;
import BehavioralDesignPatterns._Command_Pattern._Concrete_Command.TurnOffCommand;
import BehavioralDesignPatterns._Command_Pattern._Concrete_Command.TurnOnCommand;



public class Main {
    public static void main(String[] args) {
        TV tv = new TV();

        // Create commands
        Command turnOn = new TurnOnCommand(tv);
        Command turnOff = new TurnOffCommand(tv);
        Command changeChannel = new ChangeChannelCommand(tv, 5);
        Command adjustVolume = new AdjustVolumeCommand(tv, 20);

        // Create remote control
        RemoteControl remote = new RemoteControl();
        remote.setOnCommand(turnOn);
        remote.setOffCommand(turnOff);

        // Use remote control
        remote.pressOnButton();   // Turn on the TV
        remote.pressOffButton();  // Turn off the TV

        // Execute other commands indepenedently withoutt remote as well
        changeChannel.execute();  // Change the channel
        adjustVolume.execute();   // Adjust the volume

    }
}
