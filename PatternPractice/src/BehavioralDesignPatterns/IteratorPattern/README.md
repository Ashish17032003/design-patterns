# Introduction to the Iterator Design Pattern 🧩
1. The Iterator Design Pattern is a behavioral design pattern that allows us to traverse a collection of objects (like arrays or lists) without exposing the underlying implementation details. Think of it as a tour guide showing you around a museum: instead of telling you how the exhibits are arranged, the guide simply takes you through the rooms one by one, in an easy-to-follow order.

2. In software development, this pattern is extremely useful when we want to access elements in a collection (like a list or a set) sequentially without exposing the complexity of the collection itself. It decouples the way we access elements from the collection’s underlying data structure, allowing us to write cleaner, more maintainable code.

## Real-Life Scenario: Playlist Iterator 🎶
- Let’s imagine you are building a music streaming app, and one of the features is a playlist. Users can add songs to their playlists, and they should be able to iterate through their playlist to listen to each song one by one.

- Now, let’s say we have different types of playlists, such as:
• A simple playlist where songs are added in a particular order.
• A random playlist where songs are shuffled.

- Instead of writing custom code for iterating over each type of playlist, the Iterator Design Pattern will allow us to abstract the iteration logic and provide a unified way to access elements.

## Traditional Approach
```Java
import java.util.ArrayList;
public class Playlist {
      private ArrayList<String> songs;
      public Playlist() {
          songs = new ArrayList<>();
      }
      public void addSong(String song) {
          songs.add(song);
      }
      
        public void playPlaylist(boolean shuffle) {
            if (shuffle) {
                // Shuffle the songs and then play
                System.out.println("Shuffling playlist...");
                // Shuffle logic here...
            } else {
                for (int i = 0; i < songs.size(); i++) {
                    System.out.println("Playing song: " + songs.get(i));
                }
            }
        }

}
```

In the above code:
• We have a simple playlist with songs.
• We loop through the list of songs using a for loop in the playPlaylist() method.

But here’s the problem: as we add more functionality (e.g., adding shuffle functionality or filtering songs), this code will quickly become hard to maintain. Every time we want to change how we iterate through the playlist, we’ll need to modify the playPlaylist() method.

### Solving the Problem Using the Iterator Design Pattern 🚀
Let's create multiple iterators to show how the Iterator Design Pattern can handle different types of playlists. We'll add a Shuffled Playlist Iterator and a Favorites Playlist Iterator in addition to the Simple Playlist Iterator and demonstrate how each iterator can be used to iterate over different types of playlists.

// code for this is inside package
```
• The PlaylistIterator interface is the common interface that all iterators implement (SimplePlaylistIterator, ShuffledPlaylistIterator, and FavoritesPlaylistIterator).
• The Playlist class uses the PlaylistIterator to provide iteration behavior.
• Each concrete iterator (SimplePlaylistIterator, ShuffledPlaylistIterator, and FavoritesPlaylistIterator) implements the PlaylistIterator interface and provides its specific iteration logic.
• The Playlist class contains a list of songs (songs) and provides an iterator method to choose the appropriate iterator based on the type.
```