package SongRelatedClasses;

/**
 * The Jazz class represents a specific type of song, Jazz, which extends the Song class and includes
 * additional properties such as improvisation.
 */
public class Jazz extends Song {
    /**
     * Indicates whether the Jazz song includes improvisation.
     */
    private boolean improvisation;

    /**
     * Constructs a new Jazz song with the specified properties.
     *
     * @param title            The title of the song.
     * @param subGenre         The sub-genre of the song.
     * @param durationInSeconds The duration of the song in seconds.
     * @param author           The author of the song.
     * @param releaseYear      The release year of the song.
     * @param improvisation     Indicates whether the Jazz song includes improvisation.
     */
    public Jazz(String title, String subGenre, int durationInSeconds, String author, int releaseYear, boolean improvisation) {
        super(title, subGenre, durationInSeconds, author, releaseYear);
        this.improvisation = improvisation;
    }

    /**
     * Gets whether the Jazz song includes improvisation.
     *
     * @return True if the song includes improvisation, false otherwise.
     */
    public boolean getImprovisation() {
        return improvisation;
    }

    /**
     * Overrides the printInfo method to include information specific to Jazz songs.
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Has improvisation: " + getImprovisation());
        System.out.println();
    }
}
