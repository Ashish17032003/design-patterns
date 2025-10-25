package BehavioralDesignPatterns.Observer;

public interface Observer {
    // It is called by the Subject whenever something changes.
    void update(String message);
}
