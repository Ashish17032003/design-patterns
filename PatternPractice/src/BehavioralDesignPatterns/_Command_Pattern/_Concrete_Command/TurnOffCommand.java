package BehavioralDesignPatterns._Command_Pattern._Concrete_Command;

import BehavioralDesignPatterns._Command_Pattern.Command;
import BehavioralDesignPatterns._Command_Pattern.TV;

public class TurnOffCommand implements Command {
    private TV tv;
    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}
