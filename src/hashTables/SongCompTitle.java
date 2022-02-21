package hashTables;

import cs1c.SongEntry;

public class SongCompTitle implements Comparable<String>
{
    private SongEntry data;

    public SongCompTitle(SongEntry e)
    {
        data = e;
    }
    public int compareTo(String key)
        {
            return data.getTitle().compareTo(key);
    }
    public boolean equals(SongCompTitle rhs)
    {
        return data.equals(rhs.data);
    }
    public int hashCode()
    {
        return data.getTitle().hashCode();
    }
    public String toString()
    {
        return data.toString();
    }

}
