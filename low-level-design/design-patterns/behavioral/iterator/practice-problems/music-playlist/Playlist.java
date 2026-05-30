import java.util.ArrayList;
import java.util.List;

class Playlist {

    List<Song> songs = new ArrayList<>();

    public void addSong(String title) {
        songs.add(new Song(title));
    }

    public SongIterator createIterator() {
        return new PlaylistIterator(songs);
    }
}
