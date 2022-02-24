project folder:
sclkan-cs1c-project06/


Brief description of submitted files:

lib/json-simple-1.1.1.jar
    - Simple toolkit to encode or decode JSON text

src/cs1c/MillionSongDataSubset.java
    - Parses a JSON data set and stores each entry in an array

src/cs1c/SongEntry.java
    - Stores a simplified version of the genre data set from the Million Song Dataset

src/cs1c/TimeConverter.java
    - Converts duration into a string representation

src/hashTables/FHhashQP.java
    - Hash function that incorporates quadratic probing

src/hashTables/FHhashQPwFind.java
    - Extension of FHhashQP that finds an object based on key-value

src/hashTables/HashEntry.java
    - HashEntry class for use by FHhashQP

src/hashTables/MyTunes.java
    - Client that tests the functionality of FHhashQPwFind.java
    - Reads the song information from a JSON input file
    - Populate two hash tables to compare SongEntry objects based on different keys.

src/hashTables/SongCompArtist.java
    - Wrapper class that gives us the ability to compare songs based on their artists

src/hashTables/SongCompTitle.java
    - Wrapper class that gives us the ability to compare song titles
    - Determines the number of songs for each Artist

src/hashTables/TableGenerator.java
    - Class that generates hash tables for SongCompTitle and SongCompArtist
    - Prints out statistics such as the # of quadratic probes performed and the # of songs attempted to be inserted

resources/findArtists.txt
    - Provided file that contains a list of artists that tests FHhashQPwFind and SongCompArtist

resources/findArtists_additional_test.txt
    - Additional test for music_genre_subset.json
    - Can be used to test for entries with featuring artists
    - Includes entries with incorrect capitalization, misspelling, and featuring artists without own solos

resources/findTitles.txt
    - Provided file that contains a list of songs that tests FHhashQPwFind and SongCompTitle

resources/findTitles_additional_test.txt
    - Additional test for music_genre_subset.json
    - Can be used to test for songs with long titles and titles with numbers
    - Includes bad entries that have the artist name as titles and incomplete titles

resources/msd_subset_short.json
    - JSON file that contains song info like genre, title, artist, duration, and id (abbreviated version)

resources/music_genre_subset.json.json
    - JSON file that contains song info like genre, title, artist, duration, and id (full version)

resources/RUN.txt
    - Console output of MyTunes.java

README.txt
    - Description of submitted files

Discussion:

Whenever .insert() is called, the program will probe for an element while adding a new key to the table.
The insert method is used by the client when it calls populateTitleTable(allSongs) and populateArtistTable(allSongs)
in the MyTunes constructor.

Given an initial table size of 10, the actual initial table size used is 11.
When we initialize our table,  the nextPrime method is called because our input is greater than 7 (INIT_TABLE_SIZE).
11 is the first prime number after 10.

I have also run a series of tests to examine how initial table size affects the number of quadratic probes.
When the initial table size is 3:
For the Title hash table, the number of quadratic probes performed is 15
For the Artist hash table, the number of quadratic probes performed is 1

When the initial table size is 30:
For the Title hash table, the number of quadratic probes performed is 6
For the Artist hash table, the number of quadratic probes performed is 1


When the initial table size is 1000000:
For the Title hash table, the number of quadratic probes performed is 5
For the Artist hash table, the number of quadratic probes performed is 0

Based on the data above, increasing the table size tends to decrease the number of quadratic probes performed.
Therefore, these two variables seem to be negatively correlated.
This makes sense because the larger the table, the less clustering and fewer chances that two objects will cl