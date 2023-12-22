package Tests;

import TypedCollection.TypedCollection;
import org.junit.jupiter.api.Test;
import SongRelatedClasses.Song;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TypedCollectionTests {

    @Test
    void testEmptyConstructor() {
        TypedCollection collection = new TypedCollection();
        assertTrue(collection.isEmpty());
        assertEquals(0, collection.size());
    }

    @Test
    void testConstructorWithCollection() {
        List<Song> songList = Arrays.asList(
                new Song("Song1", "Rock", 200, "Author1", 2000),
                new Song("Song2", "Jazz", 180, "Author2", 1990)
        );
        TypedCollection collection = new TypedCollection(songList);
        assertFalse(collection.isEmpty());
        assertEquals(songList.size(), collection.size());
        assertTrue(collection.containsAll(songList));
    }

    @Test
    void testConstructorWithSingleSong() {
        Song song = new Song("Song1", "Rock", 200, "Author1", 2000);
        TypedCollection collection = new TypedCollection(song);
        assertFalse(collection.isEmpty());
        assertEquals(1, collection.size());
        assertTrue(collection.contains(song));
    }

    @Test
    void testSize() {
        TypedCollection collection = new TypedCollection();
        assertEquals(0, collection.size());
        collection.add(new Song("Song1", "Rock", 200, "Author1", 2000));
        assertEquals(1, collection.size());
    }

    @Test
    void testIsEmpty() {
        TypedCollection collection = new TypedCollection();
        assertTrue(collection.isEmpty());
        collection.add(new Song("Song1", "Rock", 200, "Author1", 2000));
        assertFalse(collection.isEmpty());
    }

    @Test
    void testContains() {
        TypedCollection collection = new TypedCollection();
        Song song = new Song("Song1", "Rock", 200, "Author1", 2000);
        assertFalse(collection.contains(song));
        collection.add(song);
        assertTrue(collection.contains(song));
    }

    @Test
    void testIterator() {
        TypedCollection collection = new TypedCollection();
        Song song = new Song("Song1", "Rock", 200, "Author1", 2000);
        collection.add(song);

        Iterator<Song> iterator = collection.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(song, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testToArray() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);
        collection.add(song2);

        Object[] array = collection.toArray();
        assertArrayEquals(new Object[]{song1, song2}, array);
    }



    @Test
    void testAdd() {
        TypedCollection collection = new TypedCollection();
        Song song = new Song("Song1", "Rock", 200, "Author1", 2000);
        assertTrue(collection.add(song));
        assertEquals(1, collection.size());
        assertTrue(collection.contains(song));
    }

    @Test
    void testRemove() {
        TypedCollection collection = new TypedCollection();
        Song song = new Song("Song1", "Rock", 200, "Author1", 2000);
        collection.add(song);
        assertTrue(collection.remove(song));
        assertEquals(0, collection.size());
        assertFalse(collection.contains(song));
    }

    @Test
    void testContainsAll() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);
        collection.add(song2);

        List<Song> songList = Arrays.asList(song1, song2);
        assertTrue(collection.containsAll(songList));

        songList = Arrays.asList(song1, new Song("Song3", "Pop", 210, "Author3", 2010));
        assertFalse(collection.containsAll(songList));
    }

    @Test
    void testAddAll() {
        TypedCollection collection = new TypedCollection();
        List<Song> songList = Arrays.asList(
                new Song("Song1", "Rock", 200, "Author1", 2000),
                new Song("Song2", "Jazz", 180, "Author2", 1990)
        );
        assertTrue(collection.addAll(songList));
        assertEquals(songList.size(), collection.size());
        assertTrue(collection.containsAll(songList));
    }

    @Test
    void testAddAllWithIndex() {
        TypedCollection collection = new TypedCollection();
        List<Song> songList = Arrays.asList(
                new Song("Song1", "Rock", 200, "Author1", 2000),
                new Song("Song2", "Jazz", 180, "Author2", 1990)
        );
        assertTrue(collection.addAll(0, songList));
        assertEquals(songList.size(), collection.size());
        assertTrue(collection.containsAll(songList));
        assertEquals(songList.get(0), collection.get(0));
        assertEquals(songList.get(1), collection.get(1));
    }

    @Test
    void testRemoveAll() {
        TypedCollection collection = new TypedCollection();
        List<Song> songList = Arrays.asList(
                new Song("Song1", "Rock", 200, "Author1", 2000),
                new Song("Song2", "Jazz", 180, "Author2", 1990)
        );
        collection.addAll(songList);

        List<Song> songsToRemove = Arrays.asList(songList.get(0));
        assertTrue(collection.removeAll(songsToRemove));
        assertEquals(1, collection.size());
        assertFalse(collection.contains(songsToRemove.get(0)));
    }

    @Test
    void testRetainAll() {
        TypedCollection collection = new TypedCollection();
        List<Song> songList = Arrays.asList(
                new Song("Song1", "Rock", 200, "Author1", 2000),
                new Song("Song2", "Jazz", 180, "Author2", 1990)
        );
        collection.addAll(songList);

        List<Song> songsToRetain = Arrays.asList(songList.get(0));
        assertTrue(collection.retainAll(songsToRetain));
        assertEquals(1, collection.size());
        assertTrue(collection.contains(songsToRetain.get(0)));
    }

    @Test
    void testClear() {
        TypedCollection collection = new TypedCollection();
        collection.add(new Song("Song1", "Rock", 200, "Author1", 2000));
        collection.clear();
        assertTrue(collection.isEmpty());
        assertEquals(0, collection.size());
    }

    @Test
    void testGet() {
        TypedCollection collection = new TypedCollection();
        Song song = new Song("Song1", "Rock", 200, "Author1", 2000);
        collection.add(song);
        assertEquals(song, collection.get(0));
    }



    @Test
    void testSet() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);

        Song replacedSong = collection.set(0, song2);
        assertEquals(song2, collection.get(0));
        assertEquals(song1, replacedSong);
    }

    @Test
    void testRemoveWithIndex() {
        TypedCollection collection = new TypedCollection();
        Song song = new Song("Song1", "Rock", 200, "Author1", 2000);
        collection.add(song);

        Song removedSong = collection.remove(0);
        assertEquals(0, collection.size());
        assertEquals(song, removedSong);
    }

    @Test
    void testIndexOf() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);
        collection.add(song2);

        assertEquals(0, collection.indexOf(song1));
        assertEquals(1, collection.indexOf(song2));
    }

    @Test
    void testLastIndexOf() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);
        collection.add(song2);
        collection.add(song1);

        assertEquals(2, collection.lastIndexOf(song1));
        assertEquals(1, collection.lastIndexOf(song2));
    }
    @Test
    void testTypedCollectionConstructor() {
        TypedCollection collection = new TypedCollection();
        assertNotNull(collection);
        assertTrue(collection.isEmpty());
        assertEquals(0, collection.size());
    }

    @Test
    void testTypedCollectionConstructorWithCollection() {
        List<Song> songList = Arrays.asList(
                new Song("Song1", "Rock", 200, "Author1", 2000),
                new Song("Song2", "Jazz", 180, "Author2", 1990)
        );
        TypedCollection collection = new TypedCollection(songList);
        assertNotNull(collection);
        assertFalse(collection.isEmpty());
        assertEquals(songList.size(), collection.size());
        assertTrue(collection.containsAll(songList));
    }

    @Test
    void testTypedCollectionConstructorWithSingleSong() {
        Song song = new Song("Song1", "Rock", 200, "Author1", 2000);
        TypedCollection collection = new TypedCollection(song);
        assertNotNull(collection);
        assertFalse(collection.isEmpty());
        assertEquals(1, collection.size());
        assertTrue(collection.contains(song));
    }

    @Test
    void testToArrayWithArgument() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);
        collection.add(song2);

        Song[] array = new Song[2];
        Song[] resultArray = collection.toArray(array);

        assertSame(array, resultArray);
        assertArrayEquals(new Song[]{song1, song2}, array);
    }


    @Test
    void testAddWithIndex() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);
        collection.add(0, song2);
        assertEquals(song2, collection.get(0));
        assertEquals(song1, collection.get(1));
    }

    @Test
    void testListIterator() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);
        collection.add(song2);

        ListIterator<Song> iterator = collection.listIterator();
        assertTrue(iterator.hasNext());
        assertEquals(song1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(song2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testListIteratorWithIndex() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        collection.add(song1);
        collection.add(song2);

        ListIterator<Song> iterator = collection.listIterator(1);
        assertTrue(iterator.hasNext());
        assertEquals(song2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testSubList() {
        TypedCollection collection = new TypedCollection();
        Song song1 = new Song("Song1", "Rock", 200, "Author1", 2000);
        Song song2 = new Song("Song2", "Jazz", 180, "Author2", 1990);
        Song song3 = new Song("Song3", "Pop", 210, "Author3", 2010);
        collection.addAll(Arrays.asList(song1, song2, song3));

        List<Song> subList = collection.subList(1, 3);
        assertEquals(Arrays.asList(song2, song3), subList);
    }

    @Test
    void testEnsureCapacity() {
        TypedCollection collection = new TypedCollection();
        for (int i = 0; i < 20; i++) {
            collection.add(new Song("Song" + i, "Rock", 200, "Author1", 2000));
        }
        assertEquals(20, collection.size());
    }
}