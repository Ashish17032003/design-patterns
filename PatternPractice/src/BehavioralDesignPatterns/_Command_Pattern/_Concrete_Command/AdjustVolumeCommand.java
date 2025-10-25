package BehavioralDesignPatterns._Command_Pattern._Concrete_Command;

import BehavioralDesignPatterns._Command_Pattern.Command;
import BehavioralDesignPatterns._Command_Pattern.TV;

public class AdjustVolumeCommand implements Command {
    private TV tv;
    private int volume;
    public AdjustVolumeCommand(TV tv, int volume) {
        this.tv = tv;
        this.volume = volume;
    }

    @Override
    public void execute() {
        tv.adjustVolume(volume);
    }
}
