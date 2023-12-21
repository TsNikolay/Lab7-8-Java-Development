/**
 * The Rap class represents a specific type of song, Rap, which extends the Song class and includes
 * additional properties such as tempo in BPM.
 */
public class Rap extends Song {
    /**
     * The tempo of the rap song in beats per minute (BPM).
     */
    private int tempoInBPM;

    /**
     * Constructs a new Rap song with the specified properties.
     *
     * @param title            The title of the song.
     * @param subGenre         The sub-genre of the song.
     * @param durationInSeconds The duration of the song in seconds.
     * @param author           The author of the song.
     * @param releaseYear      The release year of the song.
     * @param tempoInBPM       The tempo of the rap song in beats per minute (BPM).
     */
    public Rap(String title, String subGenre, int durationInSeconds, String author, int releaseYear, int tempoInBPM) {
        super(title, subGenre, durationInSeconds, author, releaseYear);
        this.tempoInBPM = tempoInBPM;
    }

    /**
     * Gets the tempo of the rap song in beats per minute (BPM).
     *
     * @return The tempo in BPM.
     */
    public int getTempoInBPM() {
        return tempoInBPM;
    }

    /**
     * Overrides the printInfo method to include information specific to Rap songs.
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Tempo In BPM: " + getTempoInBPM());
        System.out.println();
    }
}
