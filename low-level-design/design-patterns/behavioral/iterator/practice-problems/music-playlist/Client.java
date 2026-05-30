class Client {

    public static void main(String args[]) {

        Playlist playlist = new Playlist();
        playlist.addSong("Bohemian Rhapsody");
        playlist.addSong("Stairway to Heaven");
        playlist.addSong("Hotel California");

        SongIterator iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.nextSong().title);
        }
    }
}
