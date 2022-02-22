package hashTables;

import java.util.NoSuchElementException;

/**
 * An extension of FHhashQP that can find an object based on key-value
 * @author Sean Kan
 *
 * @param <KeyType>  Key value
 * @param <E>  Generic  object
 */
public class FHhashQPwFind<KeyType, E extends Comparable<KeyType>> extends FHhashQP<E>
{
    /**
     * Constructor with one parameter
     * @param tableSize  Table size
     */
    public FHhashQPwFind(int tableSize)
    {
        super(tableSize);
    }

    /**
     * Finds and returns an object based on key
     * @param key Key
     * @return  The found object or an exception
     */
    public E find(KeyType key)
    {
        if (mArray[findPosKey(key)].state != ACTIVE)
            throw new NoSuchElementException();
        return mArray[findPosKey(key)].data;
    }

    /**
     * Determines the hash value for the key passed
     * @param key  Key
     * @return  The hash value
     */
    protected int myHashKey(KeyType key)
    {
        int hashVal;
        hashVal = key.hashCode() % mTableSize;
        if(hashVal < 0)
            hashVal += mTableSize;
        return hashVal;
    }

    /**
     * Finds the index location of an object based on key value
     * @param key  Key
     * @return  The index location
     */
    protected int findPosKey(KeyType key)
    {
        int kthOddNum = 1;
        int index = myHashKey(key);

        while ( mArray[index].state != EMPTY
                && (mArray[index].data.compareTo(key)!=0))
        {
            index += kthOddNum; // k squared = (k-1) squared + kth odd #
            kthOddNum += 2;     // compute next odd #
            if ( index >= mTableSize )
                index -= mTableSize;
        }
        return index;
    }
}