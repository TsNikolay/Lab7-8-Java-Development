/**
 * The Song class represents a generic music track with properties such as title, sub-genre, duration,
 * author, and release year.
 */
public class Song {
    /**
     * The title of the song.
     */
    private String title;

    /**
     * The sub-genre of the song.
     */
    private String subGenre;

    /**
     * The duration of the song in seconds.
     */
    private int durationInSeconds;

    /**
     * The author of the song.
     */
    private String author;

    /**
     * The release year of the song.
     */
    private int releaseYear;

    /**
     * Constructs a new Song with the specified properties.
     *
     * @param title            The title of the song.
     * @param subGenre         The sub-genre of the song.
     * @param durationInSeconds The duration of the song in seconds.
     * @param author           The author of the song.
     * @param releaseYear      The release year of the song.
     */
    public Song(String title, String subGenre, int durationInSeconds, String author, int releaseYear) {
        this.title = title;
        this.subGenre = subGenre;
        this.durationInSeconds = durationInSeconds;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    /**
     * Checks if the duration of the song is within the specified range.
     *
     * @param min The minimum duration for comparison.
     * @param max The maximum duration for comparison.
     * @return True if the duration is within the specified range, false otherwise.
     */
    public boolean doesDurationSatisfyRange(int min, int max) {
        double songDuration = getDurationInSeconds();
        return songDuration >= min && songDuration <= max;
    }

    /**
     * Prints detailed information about the song.
     */
    public void printInfo() {
        String blueColor = "\u001B[34m";
        String orangeColor = "\u001B[33m";
        String resetColor = "\u001B[0m";

        System.out.println("Title: " + getTitle());
        System.out.println("SubGenre: " + orangeColor + getSubGenre() + resetColor);
        System.out.println("Duration: " + blueColor + getDurationInSeconds() + " seconds" + resetColor);
        System.out.println("Author: " + getAuthor());
        System.out.println("Release Year: " + getReleaseYear());
    }


    /**
     * Gets the title of the song.
     *
     * @return The title of the song.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the sub-genre of the song.
     *
     * @return The sub-genre of the song.
     */
    public String getSubGenre() {
        return subGenre;
    }

    /**
     * Gets the duration of the song in seconds.
     *
     * @return The duration of the song in seconds.
     */
    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    /**
     * Gets the author of the song.
     *
     * @return The author of the song.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the release year of the song.
     *
     * @return The release year of the song.
     */
    public int getReleaseYear() {
        return releaseYear;
    }
}
