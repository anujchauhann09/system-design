import java.util.List;

class PlaylistIterator implements SongIterator {

    List<Song> songs;
    int position = 0;

    PlaylistIterator(List<Song> songs) {
        this.songs = songs;
    }

    public boolean hasNext() {
        return position < songs.size();
    }

    public Song nextSong() {
        return songs.get(position++);
    }
}
