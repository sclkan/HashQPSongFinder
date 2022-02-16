package hashTables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs1c.MillionSongDataSubset;
import cs1c.SongEntry;

/**
 * Tests the functionality of FHhashQPwFind.java.
 * Specifically checks for implementation of find() function to return an object 
 * associated with a given key input.
 *
 * @author Foothill College, [YOUR NAME HERE]
 */
public class MyTunes 
{
	public static final boolean SHOW_DETAILS = false;

	// TODO: Create the class FHhashQPwFind to extend class FHhashQP 

	// TODO: Define the wrapper class SongCompTitle for SongEntry objects,
	//       which would compare SongEntry objects based on the song's String title field.
	private FHhashQPwFind<String, SongCompTitle>  tableOfSongTitles;

	// TODO: Define the wrapper class SongCompArtist for SongEntry objects,
	//       which would compare SongEntry objects based on the song's String artist field.
	private FHhashQPwFind<String, SongCompArtist> tableOfArtists;

	// List of artists found while populating tableOfArtist field
	private ArrayList<String> artists;


	/**
	 * Populates two hash tables where one is based on the title and the other is 
	 * based on the artist of a SongEntry object.
	 * @param allSongs	Array of SongEntry objects
	 * @param tableSize	Requested starting size for hash table.
	 */
	public MyTunes(SongEntry[] allSongs, int tableSize)
	{		
		// TODO: Define the TableGenerator class to have two class fields of type
		//       FHhashQPwFind which extend the parent class FHhashQP.
		TableGenerator g = new TableGenerator(tableSize);

		// TODO: Populates a hash table for comparing songs based on their String field title.
		//       Uses this table to keep track of a song.
		tableOfSongTitles = g.populateTitleTable(allSongs);

		// TODO: Populates a hash table for comparing songs based on their String field artist.
		//       Create a list of unique keys found.
		tableOfArtists = g.populateArtistTable(allSongs);		

		// TODO: Return the list of keys found when populating hash able of artist names.
		artists = g.getArtists();
	}

	/**
	 * Tests the FHhashQPwFind and wrapper class SongCompTitle.
	 * @param filename The input file to read.
	 */
	public void testTitleTable(String filename) 
	{
		System.out.printf("\n\nTest file for hash table of song titles: %s \n", filename);

		ArrayList<String> requests = readFindRequests(filename);
		for (String title : requests)
		{
			System.out.printf( "Requested song title \"%s\" ", title);
			try
			{
				SongCompTitle compResult  = tableOfSongTitles.find(title);
				if (compResult != null)
				{
					System.out.printf("found\n");
				}
			}
			catch (NoSuchElementException e)
			{ 
				System.out.printf("NOT found\n");
			} 
		} // for all requested titles to find

		System.out.println("Done with testing table of song titles.");
	}

	/**
	 * Tests the FHhashQPwFind and wrapper class SongCompArtist.
	 * @param filename The input file to read.
	 */
	private void testArtistTable(String filename) 
	{
		System.out.printf("\n\nTest file for hash table of artists names: %s \n", filename);

		System.out.println("\nNumber of store songs given an artist:");

		for (String currentArtist : artists)
		{
			SongCompArtist artist = tableOfArtists.find(currentArtist);
			System.out.println(artist);
		}

		ArrayList<String> requests = readFindRequests(filename);

		for (String artist : requests)
		{			
			System.out.printf( "Requested artist name \"%s\" ", artist);

			try
			{
				SongCompArtist compResult  = tableOfArtists.find(artist);
				if (compResult != null)
				{
					System.out.printf("found\n");
				}
			}
			catch (NoSuchElementException e)
			{ 
				System.out.printf("not found\n");
			} 
		} // for all requested artists to find

		System.out.println("Done with testing table of artists.");
	}
	


	/**
	 * Uses MillionSongDataSubset to read all songs from data file.
	 * @param jsonFile	A JSON file to parse
	 * @return	The array of SongEntry objects
	 */
	public static SongEntry [] readSongsFromDataFile(String jsonFile)
	{
		// parses the JSON input file
		MillionSongDataSubset msd = new MillionSongDataSubset(jsonFile);

		// retrieves the parsed objects
		SongEntry [] allSongs = msd.getArrayOfSongs();

		// displays the number of songs read from the input file
		System.out.printf("Total number of songs read %d \n", allSongs.length);
		
		return allSongs;
	}


	/**
	 * Basic file reader which reads a file with format:
	 * [value to find]
	 * [value to find]
	 * etc.
	 * And stores each value into a list.
	 * @param filename	The input file to read.
	 * @return Returns an ArrayList of lines read.
	 */
	public ArrayList<String> readFindRequests(String filename)
	{
		ArrayList<String> requests = new ArrayList<>();
		Scanner input = null;

		try 
		{
			File infile = new File(filename);
			input = new Scanner(infile);

			String line = "";
			while (input.hasNextLine()) 
			{
				line = input.nextLine(); 

				requests.add("" + line);
			} // while more lines in file
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 	
		finally
		{
			if (input != null)
				input.close();
		}
		return requests;
	}

	/**
	 * Creates an object of type MyTunes such that it reads the song information from 
	 * a JSON input file and stores all entries in an array of SongEntry objects.
	 * Populates two hash tables where each table uses different attributes of SongEntry 
	 * class as the key. Tests finding keys in each hash table and reports whether a
	 * requested key is found.
	 */
	public static void main(String[] args) 
	{
		// Directory path for JSON files
		final String DATAFILE = "resources/msd_subset_short.json";		
		//final String DATAFILE = "resources/music_genre_subset.json";	
		
		// Note: This is similar to your prior projects.
		//		 Placed in a separate method for readability.
		// Parses the input file and stores all songs in an array of SongEntry object.
		SongEntry [] allSongs = readSongsFromDataFile(DATAFILE);

		// The constructor of class builds the hash tables
		final int REQUESTED_TABLE_SIZE = 10;
		System.out.printf("Testing with requested table size %s\n", REQUESTED_TABLE_SIZE);
		MyTunes tunesStore = new MyTunes(allSongs, REQUESTED_TABLE_SIZE);

		// Tests FHhashQPwFind and SongCompTitle
		// Note: Include your own test file in addition to the provided example test 
		//       file based on the song title.
		String requestedTitles = "resources/findTitles.txt";
		tunesStore.testTitleTable(requestedTitles);

		// Tests FHhashQPwFind and SongCompArtist
		// Note: Include your own test file in addition to the provided example test 
		//       file based on the artist name.
		String requestedArtists = "resources/findArtists.txt";	
		tunesStore.testArtistTable(requestedArtists); 

		// flush the error stream
		System.err.flush();

		System.out.println("\nDone with MyTunes.");
	}
}
