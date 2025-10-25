package BehavioralDesignPatterns.IteratorPattern._Concrete_Iterators;

import BehavioralDesignPatterns.IteratorPattern.Playlist;
import BehavioralDesignPatterns.IteratorPattern.PlaylistIterator;

public class SimplePlaylistIterator implements PlaylistIterator {
    private Playlist playlist;
    private int index;
    public SimplePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        return index < playlist.getSongs().size();
    }
    @Override
    public String next() {
        return playlist.getSongs().get(index++);
    }
}
