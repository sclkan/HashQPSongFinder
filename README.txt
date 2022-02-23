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
    - Contains a list of artists that tests FHhashQPwFind and SongCompArtist

resources/findTitles.txt
    - Contains a list of songs that tests FHhashQPwFind and SongCompTitle

resources/msd_subset_short.json
    - JSON file that contains song info like genre, title, artist, duration, and id (abbreviated version)

resources/music_genre_subset.json.json
    - JSON file that contains song info like genre, title, artist, duration, and id (full version)

resources/RUN.txt
    - Console output of MyTunes.java

README.txt
    - Description of submitted files