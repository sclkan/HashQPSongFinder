package hashTables;

import cs1c.SongEntry;
import java.util.ArrayList;

/**
 * A class that generates hash tables for SongCompTitle and SongCompArtist
 * @author Sean Kan
 */
public class TableGenerator 
{
    private ArrayList<String> artistNames;
    private FHhashQPwFind<String, SongCompTitle> tableOfSongTitle;
    private FHhashQPwFind<String, SongCompArtist> tableOfArtists;

    /**
     * Constructor that takes one parameter
     * Initializes all three attributes
     * @param tableSize  The initial table size
     */
    public TableGenerator(int tableSize)
    {
        tableOfSongTitle = new FHhashQPwFind<String, SongCompTitle>(tableSize);
        tableOfArtists = new FHhashQPwFind<String, SongCompArtist>(tableSize);
        artistNames = new ArrayList<>();
    }

    /**
     * Populates a hash table for comparing songs based on their String field title.
     * @param songs  SongEntry objects (an array of songs)
     * @return Hash table
     */
    public FHhashQPwFind<String, SongCompTitle> populateTitleTable(SongEntry[] songs)
    {
        int insertCounter=0;
        for (int i=0; i<songs.length; i++)
        {
            SongCompTitle song = new SongCompTitle(songs[i]);
            tableOfSongTitle.insert(song);
            insertCounter++;
        }

        System.out.println("\nPopulating hash table of song titles...");
        System.out.println("Number of songs attempted to insert: " + insertCounter);
        System.out.println("Number of quadratic probes perform: " + tableOfSongTitle.getCountOfProbes());
        System.out.println("Final table size for the hash table of song titles: " + tableOfSongTitle.mTableSize);

        return tableOfSongTitle;
    }

    /**
     * Populates a hash table for comparing songs based on their String field artist.
     * @param songs   SongEntry objects (an array of songs)
     * @return   Hash table
     */
    public FHhashQPwFind<String, SongCompArtist> populateArtistTable(SongEntry[] songs)
    {
        int insertCounter=0;
        for (int i=0; i<songs.length; i++)
        {
            if (!artistNames.contains(songs[i].getArtistName()))
            {
                artistNames.add(songs[i].getArtistName());
                SongCompArtist artist = new SongCompArtist(songs[i]);
                tableOfArtists.insert(artist);
            }
            else
                tableOfArtists.find(songs[i].getArtistName()).addSong(songs[i]);
            insertCounter++;
        }

        System.out.println("\nPopulating hash table of artists...");
        System.out.println("Number of songs attempted to insert: " + insertCounter);
        System.out.println("Number of quadratic probes perform: " + tableOfArtists.getCountOfProbes());
        System.out.println("Final table size for the hash table of artist names: " + tableOfArtists.mTableSize);

        return tableOfArtists;
    }

    /**
     * Getter method for artistName
     * @return   An arrayList that contains artist names
     */
    public ArrayList<String> getArtists()
    {
        return artistNames;
    }
}