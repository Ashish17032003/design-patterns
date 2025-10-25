package BehavioralDesignPatterns.Observer;

// Concrete Observers (Subscribers)
public class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    // Each Concrete BehavioralDesignPatterns.Observer must implement update() to define how it reacts to change
    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}
