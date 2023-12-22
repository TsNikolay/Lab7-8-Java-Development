package TypedCollection;

import SongRelatedClasses.Song;

import java.util.*;

/**
 * A typed collection of songs.
 */
public class TypedCollection implements List<Song> {
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    private Song[] songs;
    private int size;

    /**
     * Constructs an empty SongCollection.
     */
    public TypedCollection() {
        songs = new Song[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Constructs a TypedCollection.TypedCollection with songs from the given collection.
     *
     * @param TypedCollection The collection of songs to be added to this SongCollection.
     */
    public TypedCollection(Collection<Song> TypedCollection) {
        this();
        addAll(TypedCollection);
    }

    /**
     * Constructs a TypedCollection.TypedCollection with a single song.
     *
     * @param song The song to be added to this SongCollection.
     */
    public TypedCollection(Song song) {
        this();
        add(song);
    }

    // Implementing List interface methods...

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Song song : songs) {
                if (song == null) {
                    return true;
                }
            }
        } else {
            for (Song song : songs) {
                if (o.equals(song)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public Iterator<Song> iterator() {
        return Arrays.asList(Arrays.copyOf(songs, size)).iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(songs, size);
    }

    @Override
    public <Song> Song[] toArray(Song[] a) {
        if (a.length < size) {

            return (Song[]) Arrays.copyOf(songs, size, a.getClass());
        }
        System.arraycopy(songs, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }


    @Override
    public boolean add(Song song) {
        ensureCapacity();
        songs[size++] = song;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (songs[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Song> c) {
        ensureCapacity();
        for (Song song : c) {
            add(song);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Song> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        int shift = c.size();
        if (size - index > 0) {
            System.arraycopy(songs, index, songs, index + shift, size - index);
        }
        for (Song song : c) {
            songs[index++] = song;
        }
        size += shift;
        return shift != 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object obj : c) {
            modified |= remove(obj);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(songs[i])) {
                remove(i);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        songs = new Song[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public Song get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return songs[index];
    }

    @Override
    public void add(int index, Song element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(songs, index, songs, index + 1, size - index);
        songs[index] = element;
        size++;
    }

    @Override
    public Song set(int index, Song element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == 0) {
            add(element);
            return element;
        } else {

            Song previousSong = songs[index];
            songs[index] = element;
            return previousSong;
        }
    }



    @Override
    public Song remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Song removedSong = songs[index];
        System.arraycopy(songs, index + 1, songs, index, size - index - 1);
        songs[--size] = null;
        return removedSong;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (songs[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (songs[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<Song> listIterator() {
        return Arrays.asList(Arrays.copyOf(songs, size)).listIterator();
    }

    @Override
    public ListIterator<Song> listIterator(int index) {
        return Arrays.asList(Arrays.copyOf(songs, size)).listIterator(index);
    }

    @Override
    public List<Song> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", Size: " + size);
        }
        return Arrays.asList(Arrays.copyOfRange(songs, fromIndex, toIndex));
    }

    /**
     * Increases the capacity of this SongCollection if necessary.
     */
    public void ensureCapacity() {
        if (size == songs.length) {
            int newCapacity = (int) (size * GROWTH_FACTOR);
            songs = Arrays.copyOf(songs, newCapacity);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            Song element =  songs[i];
            sb.append(element.getTitle() + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(']');
        return sb.toString();
    }

}
