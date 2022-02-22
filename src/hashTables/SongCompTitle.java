package hashTables;

import cs1c.SongEntry;

/**
 * A wrapper class that gives us the ability to compare song titles
 * @author Sean Kan
 */
public class SongCompTitle implements Comparable<String>
{
    private SongEntry data;

    /**
     * Constructor with one parameter
     * @param e  SongEntry object
     */
    public SongCompTitle(SongEntry e)
    {
        data = e;
    }

    /**
     * Uses compareTo() to implement our find on key
     * @param key  Key which is the song title
     * @return Zero if the strings are identical
     */
    @Override
    public int compareTo(String key)
        {
            return data.getTitle().compareTo(key);
    }

    /**
     * Preserves the equals() provided by embedded data
     * @param rhs SongCompTitle object
     * @return True if data are equal
     */
    public boolean equals(SongCompTitle rhs)
    {
        return data.equals(rhs.data);
    }

    /**
     *Obtains the hash code
     * @return The hash code of the song title
     */
    @Override
    public int hashCode()
    {
        return data.getTitle().hashCode();
    }

    /**
     * Returns value in string format
     * @return Output of all the elements of a SongEntry object
     */
    @Override
    public String toString()
    {
        return data.toString();
    }
}
