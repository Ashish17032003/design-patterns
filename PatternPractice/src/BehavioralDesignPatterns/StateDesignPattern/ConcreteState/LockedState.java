package BehavioralDesignPatterns.StateDesignPattern.ConcreteState;

import BehavioralDesignPatterns.StateDesignPattern.Phone;
import BehavioralDesignPatterns.StateDesignPattern.State;
import BehavioralDesignPatterns.StateDesignPattern.ConcreteState.OffState;
import BehavioralDesignPatterns.StateDesignPattern.ConcreteState.ReadyState;


public class LockedState extends State {
    public LockedState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setState((new ReadyState(phone)));
        return phone.unlock();
    }

    @Override
    public String onOffOn() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
