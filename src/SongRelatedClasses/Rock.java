package SongRelatedClasses;

/**
 * The Rock class represents a specific type of song, Rock, which extends the Song class and includes
 * additional properties such as guitar solo duration.
 */
public class Rock extends Song {
    /**
     * The duration of the guitar solo in seconds.
     */
    private int guitarSoloDuration;

    /**
     * Constructs a new Rock song with the specified properties.
     *
     * @param title            The title of the song.
     * @param subGenre         The sub-genre of the song.
     * @param durationInSeconds The duration of the song in seconds.
     * @param author           The author of the song.
     * @param releaseYear      The release year of the song.
     * @param guitarSoloDuration The duration of the guitar solo in seconds.
     */
    public Rock(String title, String subGenre, int durationInSeconds, String author, int releaseYear, int guitarSoloDuration) {
        super(title, subGenre, durationInSeconds, author, releaseYear);
        this.guitarSoloDuration = guitarSoloDuration;
    }

    /**
     * Gets the duration of the guitar solo in seconds.
     *
     * @return The guitar solo duration.
     */
    public int getGuitarSoloDuration() {
        return guitarSoloDuration;
    }

    /**
     * Overrides the printInfo method to include information specific to Rock songs.
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Guitar Solo Duration: " + getGuitarSoloDuration());
        System.out.println();
    }
}
