import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The Disk class represents a collection of songs and provides methods to manage and manipulate
 * the songs within the collection.
 */
public class Disk {
    /**
     * The list of songs in the album.
     */
    private ArrayList<Song> album = new ArrayList<>();

    /**
     * Calculates the total duration of all songs in the album and returns a formatted string.
     *
     * @return A string representing the total duration of the album.
     */
    public String countAlbumDuration() {
        double totalDuration = 0;
        for (Song song : album) {
            totalDuration += song.getDurationInSeconds();
        }

        int minutes = (int) totalDuration / 60;
        int seconds = (int) totalDuration % 60;

        return minutes + "хв " + seconds + "сек";


    }

    /**
     * Adds a new song to the album.
     *
     * @param newSong The song to be added to the album.
     */
    public void addSong(Song newSong) {
        album.add(newSong);
    }

    /**
     * Sorts the songs in the album based on their sub-genre.
     */
    public void sortSongBySubGenre() {
        Collections.sort(album, Comparator.comparing(Song::getSubGenre));
    }

    /**
     * Finds and prints songs within a specified duration range.
     *
     * @param min The minimum duration for searching.
     * @param max The maximum duration for searching.
     */
    public void findSongsByDurationRange(int min, int max) {
        ArrayList<Song> searchedSongs = new ArrayList<>();
        if (min < 0 || max < 0) {
            System.out.println("Тривалість менше нулю, введіть додатне число");
            return;
        }

        for (Song song : album) {
            if (song.doesDurationSatisfyRange(min, max)) {
                searchedSongs.add(song);
            }
        }

        if (searchedSongs.isEmpty()) {
            System.out.println("Нема пісень з такою тривалістю");
        } else {
            System.out.println("Пісні від " + min + "сек до " + max + "сек:");
            for (Song song : searchedSongs) {
                song.printInfo();
            }
        }
    }

    /**
     * Prints the information of all songs in the album.
     */
    public void printList() {
        for (Song song : album) {
            song.printInfo();
        }
    }
}
