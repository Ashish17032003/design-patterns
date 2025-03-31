package Observer;

import java.util.ArrayList;
import java.util.List;

// Step 3: Concrete Subject (YouTube Channel)
public class YoutubeChannel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();
    private String latestVideo;

    public void uploadVideo(String title) {
        this.latestVideo = title;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer subscriber : subscribers) {
            subscriber.update("New Video Uploaded: " + latestVideo);
        }
    }
}
