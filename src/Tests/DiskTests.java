package Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SongRelatedClasses.Disk;
import SongRelatedClasses.Song;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiskTests {

    private Disk disk;

    @BeforeEach
    void setUp() {
        disk = new Disk();
    }

    @Test
    void testCountAlbumDuration() {
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);

        disk.addSong(song1);
        disk.addSong(song2);

        String result = disk.countAlbumDuration();
        assertEquals("6хв 20сек", result);
    }

    @Test
    void testAddSong() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);
        disk.addSong(song);
        assertEquals(Arrays.asList(song), disk.getAlbum());
    }

    @Test
    void testSortSongBySubGenre() {
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        Song song3 = new Song("Song3", "Pop", 210, "Author3", 2010);

        disk.addSong(song3);
        disk.addSong(song1);
        disk.addSong(song2);

        disk.sortSongBySubGenre();

        ArrayList<Song> sortedSongs = new ArrayList<>(Arrays.asList(song2, song3, song1));
        assertEquals(sortedSongs, disk.getAlbum());
    }

    @Test
    void testFindSongsByDurationRange() {
        Song song1 = new Song("Song1", "Rock", 180, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 200, "Author2", 1990);
        Song song3 = new Song("Song3", "Pop", 210, "Author3", 2010);

        disk.addSong(song1);
        disk.addSong(song2);
        disk.addSong(song3);

        // Redirect System.out for testing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        disk.findSongsByDurationRange(200, 210);

        String expectedOutput = "Пісні від 200сек до 210сек:" + System.lineSeparator() +
                "Title: Song2" + System.lineSeparator() +
                "SubGenre: Jazz" + System.lineSeparator() +
                "Duration: 200 seconds" + System.lineSeparator() +
                "Author: Author2" + System.lineSeparator() +
                "Release Year: 1990" + System.lineSeparator() +
                "Title: Song3" + System.lineSeparator() +
                "SubGenre: Pop" + System.lineSeparator() +
                "Duration: 210 seconds" + System.lineSeparator() +
                "Author: Author3" + System.lineSeparator() +
                "Release Year: 2010"+ System.lineSeparator() ;

        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    void testPrintList() {
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);

        disk.addSong(song1);
        disk.addSong(song2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        disk.printList();

        String expectedOutput = "Title: Song1" + System.lineSeparator() +
                "SubGenre: Rock" + System.lineSeparator() +
                "Duration: 200 seconds" + System.lineSeparator() +
                "Author: Author1" + System.lineSeparator() +
                "Release Year: 2000" + System.lineSeparator() +
                "Title: Song2" + System.lineSeparator() +
                "SubGenre: Jazz" + System.lineSeparator() +
                "Duration: 180 seconds" + System.lineSeparator() +
                "Author: Author2" + System.lineSeparator() +
                "Release Year: 1990"+ System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }

}
