package BehavioralDesignPatterns._Command_Pattern;

public class TV {
    public void turnOn() {
        System.out.println("TV ON");
    }
    public void turnOff() {
        System.out.println("TV OFF");
    }
    public void changeChannel(int channel) {
        System.out.println("TV CHANNEL changed to " + channel);
    }
    public void adjustVolume(int volume) {
        System.out.println("TV VOLUME set to " + volume);
    }

}
