package BehavioralDesignPatterns.StateDesignPattern;

import BehavioralDesignPatterns.StateDesignPattern.ConcreteState.OffState;

public class Phone {
    private State state;
    public Phone() {
        state = new OffState(this); // default state
    }

    public void setState(State state) {
        this.state = state;
    }

    public String lock() {
        return "Locking phone and turning off screen";
    }

    public String unlock() {
        return "Unlocking the phone to home";
    }

    public String turnOn() {
        return "Turning device on, screen still locked";
    }

    public String home() {
        return "Going to home-screen";
    }
}
