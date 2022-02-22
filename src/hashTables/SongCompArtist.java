package hashTables;

import cs1c.SongEntry;
import java.util.ArrayList;

/**
 *Wrapper class that gives us the ability to compare songs based on their artists
 * @author Sean Kan
 */
public class SongCompArtist implements Comparable<String>
{
    private String artist;
    private ArrayList<SongEntry> songs;

    /**
     * Constructor that initializes artist name and an ArrayList of their songs
     * @param e   SongEntry object
     */
    public SongCompArtist(SongEntry e)
    {
        artist = e.getArtistName();
        songs = new ArrayList<>();
        songs.add(e);
    }

    /**
     * Uses compareTo() to implement our find on key
     * @param key  Key which is the artist name
     * @return Zero if the strings are identical
     */
    @Override
    public int compareTo(String key)
    {
        return artist.compareTo(key);
    }

    /**
     * Preserves the equals() provided by embedded data
     * @param rhs  SongCompArtist object
     * @return  True if data are equal
     */
    public boolean equals(SongCompArtist rhs)
    {
        return artist.equals(rhs.artist);
    }

    /**
     * Adds a song to an existing SongCompArtist's ArrayList
     * @param e   SongEntry object
     */
    protected void addSong(SongEntry e)
    {
        if (compareTo(e.getArtistName())==0)
            songs.add(e);
        else
            System.out.print("Error: Artist Cannot Be Different!");
    }

    /**
     * Obtains the hash code
     * @return  The hash code of the artist
     */
    @Override
    public int hashCode()
    {
        return artist.hashCode();
    }

    /**
     * Returns value in string format
     * @return The artist name and the number of songs in its array
     */
    @Override
    public String toString()
    {
        return  artist + " size\t"
            + songs.size();
    }

    /**
     *Getter method for Artist
     * @return  artist name
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Getter method for Songs
     * @return  An arraylist that contains songs of a particular artist
     */
    public ArrayList<SongEntry> getSongs()
    {
        return songs;
    }
}
