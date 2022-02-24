package hashTables;

/**
 * HashEntry class for use by FHhashQP
 * @param <E>   Generic object
 */
public class HashEntry<E>
{
   public E data;
   public int state;

   /**
    * Constructor that takes two parameters
    * @param x   Generic object (SongEntry)
    * @param st  State (Active/Empty/Deleted)
    */
   public HashEntry( E x, int st )
   {
      data = x;
      state = st;
   }

   /**
    * Constructor with no parameters
    */
   public HashEntry()
   {
      this(null, FHhashQP.EMPTY);
   }
}
