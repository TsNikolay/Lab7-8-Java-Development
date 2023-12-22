import SongRelatedClasses.*;
import TypedCollection.TypedCollection;

import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Creating a TypedCollection.TypedCollection object
        TypedCollection songCollection = new TypedCollection();
        String greenColor = "\u001B[32m";
        String resetColor = "\u001B[0m";

        // Adding some Song objects to the collection
        Rap rapSong = new Rap("Search", "Lyrics", 240, "NF", 2020, 120);
        Rock rockSong = new Rock("Believer", "Energetic", 190, "Imagine Dragons", 2016, 50);
        Jazz jazzSong = new Jazz("World", "Blues", 195, "Louis Armstrong", 1990, true);

        // Method 2: isEmpty()
        System.out.println(greenColor + "Is the collection empty? " + resetColor + songCollection.isEmpty());
        System.out.println("-------------------------------------");

        // Method 6: add(E e)
        System.out.println(greenColor + "Let's add three songs: Search, Believer, World " + resetColor);
        songCollection.add(rapSong);
        songCollection.add(rockSong);
        songCollection.add(jazzSong);

        // Method 1: size()
        System.out.println(greenColor + "Song Collection Size: " + resetColor + songCollection.size());
        System.out.println("-------------------------------------");

        // Method 3: contains(Object o)
        System.out.println(greenColor + "Does the collection contain Search? " + resetColor + songCollection.contains(rapSong));
        System.out.println("-------------------------------------");

        // Method 4: iterator()
        System.out.println(greenColor + "Songs in the Collection:" + resetColor);
        System.out.println(songCollection);
        System.out.println("-------------------------------------");

        // Method 5: toArray()
        System.out.println(greenColor + "Array representation of the collection:" + resetColor);
        Object[] songArray = songCollection.toArray();
        for (Object obj : songArray) {
            System.out.println(obj);
        }
        System.out.println("-------------------------------------");

        // Method 13: get(int index)
        Song retrievedSong = songCollection.get(0);
        System.out.println(greenColor + "Song at index 0:" + resetColor);
        if (retrievedSong != null) {
            retrievedSong.printTitle();
            System.out.println("-------------------------------------");
        }

        // Method 7: remove(Object o)
        System.out.println(greenColor + "Removing rockSong from the collection: " + resetColor + songCollection.remove(rockSong));

        // Method 8: containsAll(Collection<?> c)
        System.out.println(greenColor + "Does the collection contain all songs in a list (Search, World)? " + resetColor
                + songCollection.containsAll(List.of(rapSong, jazzSong)));

        System.out.println(greenColor + "Let's add Song4 and Song5" + resetColor);
        // Method 9: addAll(Collection<? extends E> c)
        Song song4 = new Song("Song4", "Genre3", 200, "Author4", 2010);
        Song song5 = new Song("Song5", "Genre1", 160, "Author5", 2005);
        Song song6 = new Song("Song6", "Genre2", 160, "Author5", 2005);
        songCollection.addAll(List.of(song4, song5, song6));
        System.out.println(songCollection);

        System.out.println(greenColor + "Let's remove Song4, Song5 and Song6" + resetColor);
        // Method 10: removeAll(Collection<?> c)
        songCollection.removeAll(List.of(song4, song5));
        System.out.println(songCollection);

        System.out.println(greenColor + "Let's remove all elements except Search, World " + resetColor);
        // Method 11: retainAll(Collection<?> c)
        songCollection.retainAll(List.of(rapSong, jazzSong));
        System.out.println(songCollection);

        System.out.println(greenColor + "Let's remove all elements" + resetColor);
        // Method 12: clear()
        songCollection.clear();
        System.out.println(songCollection);

        // Method 14: set(int index, E element)
        Song newSong1 = new Song("NewTitle1", "NewGenre", 240, "NewAuthor", 2022);
        Song newSong2 = new Song("NewTitle2", "NewGenre", 240, "NewAuthor", 2022);
        Song newSong3 = new Song("NewTitle3", "NewGenre", 240, "NewAuthor", 2022);

        System.out.println(greenColor + "Let's add NewTitle1 and NewTitle2 " + resetColor);
        songCollection.set(0, newSong1);
        songCollection.add(newSong2);
        System.out.println(songCollection);
        System.out.println(greenColor + "Let's replace NewTitle2 by NewTitle3 " + resetColor);

        songCollection.set(1, newSong3);
        System.out.println(songCollection);
        System.out.println("-------------------------------------");

        // Method 15: indexOf(Object o)
        System.out.println(greenColor + "Index of the NewTitle1: " + resetColor + songCollection.indexOf(newSong1));

        // Method 16: lastIndexOf(Object o)
        System.out.println(greenColor + "Last index of the NewTitle1: " + resetColor + songCollection.lastIndexOf(newSong1));

        // Method 17: listIterator()
        ListIterator<Song> listIterator = songCollection.listIterator();
        System.out.println(greenColor + "Forward iteration using ListIterator:" + resetColor);
        while (listIterator.hasNext()) {
            listIterator.next().printTitle();
        }

        // Method 18: subList(int fromIndex, int toIndex)
        List<Song> subList = songCollection.subList(0, 1);
        System.out.println(greenColor + "Sublist from index 0 to 1:" + resetColor);
        for (Song song : subList) {
            song.printTitle();
        }

        // Method 19: ensureCapacity()
        // Note: The ensureCapacity method is called internally when needed.

        // Print the final state of the collection
        System.out.println(greenColor + "Final state of the Song Collection:" + resetColor);
        for (Song song : songCollection) {
            if (song != null) {
                song.printTitle();
            }
        }
    }
}
