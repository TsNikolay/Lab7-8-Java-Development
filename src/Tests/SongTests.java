package Tests;

import org.junit.jupiter.api.Test;
import SongRelatedClasses.Song;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SongTests {

    @Test
    void testDoesDurationSatisfyRange() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);

        assertTrue(song.doesDurationSatisfyRange(100, 300));
        assertFalse(song.doesDurationSatisfyRange(0, 100));
        assertFalse(song.doesDurationSatisfyRange(300, 400));
    }

    @Test
    void testPrintInfo() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        song.printInfo();

        String expectedOutput = "Title: TestSong" + System.lineSeparator() +
                "SubGenre: TestGenre" + System.lineSeparator() +
                "Duration: 200 seconds" + System.lineSeparator() +
                "Author: TestAuthor" + System.lineSeparator() +
                "Release Year: 2022" + System.lineSeparator();


        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintTitle() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        song.printTitle();

        assertEquals("TestSong" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void testGetTitle() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);
        assertEquals("TestSong", song.getTitle());
    }

    @Test
    void testGetSubGenre() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);
        assertEquals("TestGenre", song.getSubGenre());
    }

    @Test
    void testGetDurationInSeconds() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);
        assertEquals(200, song.getDurationInSeconds());
    }

    @Test
    void testGetAuthor() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);
        assertEquals("TestAuthor", song.getAuthor());
    }

    @Test
    void testGetReleaseYear() {
        Song song = new Song("TestSong", "TestGenre", 200, "TestAuthor", 2022);
        assertEquals(2022, song.getReleaseYear());
    }
}
