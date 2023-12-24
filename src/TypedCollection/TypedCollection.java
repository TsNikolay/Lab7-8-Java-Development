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
        try {
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
        } catch (Exception e) {
            throw new ExceptionHandler("Error checking if TypedCollection contains an object: " + e.getMessage());
        }
    }

    @Override
    public Iterator<Song> iterator() {
        return Arrays.asList(Arrays.copyOf(songs, size)).iterator();
    }

    @Override
    public Object[] toArray() {
        try {
            return Arrays.copyOf(songs, size);
        } catch (Exception e) {
            throw new ExceptionHandler("Error converting TypedCollection to an array: " + e.getMessage());
        }
    }

    @Override
    public <Song> Song[] toArray(Song[] a) {
        try {
            if (a.length < size) {
                return (Song[]) Arrays.copyOf(songs, size, a.getClass());
            }
            System.arraycopy(songs, 0, a, 0, size);
            if (a.length > size) {
                a[size] = null;
            }
            return a;
        } catch (Exception e) {
            throw new ExceptionHandler("Error converting TypedCollection to a typed array: " + e.getMessage());
        }
    }

    @Override
    public boolean add(Song song) {
        try {
            ensureCapacity();
            songs[size++] = song;
            return true;
        } catch (Exception e) {
            throw new ExceptionHandler("Error adding song: " + e.getMessage());
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            for (int i = 0; i < size; i++) {
                if (songs[i].equals(o)) {
                    remove(i);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            throw new ExceptionHandler("Error removing object: " + e.getMessage());
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            for (Object obj : c) {
                if (!contains(obj)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            throw new ExceptionHandler("Error checking if TypedCollection contains all elements: " + e.getMessage());
        }
    }

    @Override
    public boolean addAll(Collection<? extends Song> c) {
        try {
            ensureCapacity();
            for (Song song : c) {
                add(song);
            }
            return true;
        } catch (Exception e) {
            throw new ExceptionHandler("Error adding all songs from a collection: " + e.getMessage());
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends Song> c) {
        try {
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
        } catch (Exception e) {
            throw new ExceptionHandler("Error adding songs at index: " + index + ", " + e.getMessage());
        }
    }


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


    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            boolean modified = false;
            for (Object obj : c) {
                modified |= remove(obj);
            }
            return modified;
        } catch (Exception e) {
            throw new ExceptionHandler("Error removing all elements: " + e.getMessage());
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            boolean modified = false;
            for (int i = 0; i < size; i++) {
                if (!c.contains(songs[i])) {
                    remove(i);
                    modified = true;
                }
            }
            return modified;
        } catch (Exception e) {
            throw new ExceptionHandler("Error retaining elements: " + e.getMessage());
        }
    }

    @Override
    public void clear() {
        try {
            songs = new Song[INITIAL_CAPACITY];
            size = 0;
        } catch (Exception e) {
            throw new ExceptionHandler("Error clearing the collection: " + e.getMessage());
        }
    }

    @Override
    public Song get(int index) {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            return songs[index];
        } catch (Exception e) {
            throw new ExceptionHandler("Error getting element at index: " + index + ", " + e.getMessage());
        }
    }

    @Override
    public void add(int index, Song element) {
        try {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            ensureCapacity();
            System.arraycopy(songs, index, songs, index + 1, size - index);
            songs[index] = element;
            size++;
        } catch (Exception e) {
            throw new ExceptionHandler("Error adding element at index: " + index + ", " + e.getMessage());
        }
    }

    @Override
    public Song set(int index, Song element) {
        try {
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
        } catch (Exception e) {
            throw new ExceptionHandler("Error setting element at index: " + index + ", " + e.getMessage());
        }
    }

    @Override
    public Song remove(int index) {
        try {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            Song removedSong = songs[index];
            System.arraycopy(songs, index + 1, songs, index, size - index - 1);
            songs[--size] = null;
            return removedSong;
        } catch (Exception e) {
            throw new ExceptionHandler("Error removing element at index: " + index + ", " + e.getMessage());
        }
    }

    @Override
    public int indexOf(Object o) {
        try {
            for (int i = 0; i < size; i++) {
                if (songs[i].equals(o)) {
                    return i;
                }
            }
            return -1;
        } catch (Exception e) {
            throw new ExceptionHandler("Error getting index of an element: " + e.getMessage());
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            for (int i = size - 1; i >= 0; i--) {
                if (songs[i].equals(o)) {
                    return i;
                }
            }
            return -1;
        } catch (Exception e) {
            throw new ExceptionHandler("Error getting last index of an element: " + e.getMessage());
        }
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
        try {
            if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
                throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", Size: " + size);
            }
            return Arrays.asList(Arrays.copyOfRange(songs, fromIndex, toIndex));
        } catch (Exception e) {
            throw new ExceptionHandler("Error creating subList: " + e.getMessage());
        }
    }
}
