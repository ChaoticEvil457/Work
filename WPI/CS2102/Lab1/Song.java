package Lab1;
class Song {
    String title;
    int lenInSeconds; // duration of the song
    Album onAlbum;
    Song(String title, Integer lenInSeconds, Album onAlbum) {
        this.title = title;
        this.lenInSeconds = lenInSeconds;
        this.onAlbum = onAlbum;
    }
}