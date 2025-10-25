package BehavioralDesignPatterns.Observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();

        Observer user1 = new Subscriber("Alice");
        Observer user2 = new Subscriber("Bob");

        channel.register(user1);
        channel.register(user2);

        channel.uploadVideo("BehavioralDesignPatterns.Observer Pattern in Java!");

        // Bob unsubscribes
        channel.unregister(user2);

        channel.uploadVideo("Factory vs Strategy Pattern!");
    }
}
