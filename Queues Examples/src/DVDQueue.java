import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stores a queue of DVD objects
 * @author Iain Martin
 * @version 1.0
 */
public class DVDQueue
{
    private Queue<DVD> dvdQueue; // stores a queue of DVDs.

    /**
     * Default constructor. Initialise fields to default values.
     */
    public DVDQueue()
    {
        dvdQueue = new LinkedList<DVD>();
    }

    /**
     * Add a given DVD object to the end of the queue 
     * 
     * @param dvdToAdd A reference to the DVD object to add to the queue
     * @return True if the DVD is successfully added to the queue.
     * 
     * NOTE: an exception will be thrown under certain conditions, e.g. an attempt to add
     * an empty / null object to queue, capacity restrictions on the size of the queue,
     * an attempt to add an unexpected type of object to a queue. For improved
     * robustness one could consider catching these exceptions if they arise.
     */
    public boolean addToQueue(DVD dvdToAdd)
    {
        // call method on queue object to add object to end of it
        return dvdQueue.add(dvdToAdd);
    }

    /**
     * Add a DVD object to the end of the queue using the DVD details provided.
     * 
     * @param title The title of the DVD
     * @param leadActor The name of the lead actor
     * @return True if the DVD is successfully added to the queue.
     * 
     * NOTE: an exception will be thrown under certain conditions, e.g. an attempt to add
     * an empty / null object to queue, capacity restrictions on the size of the queue,
     * an attempt to add an unexpected type of object to a queue. For improved
     * robustness one could consider catching these exceptions if they arise.
     */
    public boolean addToQueue(String title, String leadActor)
    {
        // create a DVD object using the details provided
        DVD dvd = new DVD(title, leadActor);

        // call method on queue object to add DVD object to the end of it
        return dvdQueue.add(dvd);
    }

    /**
     * Remove the DVD at the front of Queue and return a reference to it.
     * 
     * @return A reference to the DVD object removed from the front of the queue, or null if the queue is empty 
     * 
     * NOTE: an exception will be thrown if an attempt is made to remove an item
     * from an empty queue.
     */
    public DVD removeFromQueue()
    {
        DVD dvdRemoved; // stores a reference to the removed item
        
        try
        {
            // call method on queue object which removes and returns a reference to the 
            // item at the front of the queue
            dvdRemoved = dvdQueue.remove();
        }
        catch (NoSuchElementException e)
        {
            // attempt to remove item from an empty queue
            // no element to return
            dvdRemoved = null;
        }
        
        // return item removed
        return dvdRemoved;
    }

    /**
     * Determine if the queue is empty or not
     * 
     * @return True if queue is empty
     */
    public boolean isEmpty()
    {
        // call method on queue object to check if empty
        return dvdQueue.isEmpty();
    }

    /**
     * Get the length of the queue, i.e. the number of items it contains
     * 
     * @return The number of items in the queue
     */
    public int getLength()
    {
        // call method on queue object to get queue size
        return dvdQueue.size();
    }

    /**
     * Get the iterator for the queue, so it can be traversed
     * 
     * @return The iterator for the queue 
     */
    public Iterator<DVD> getIterator()
    {
        // call method on queue object to get iterator
        return dvdQueue.iterator();
    }

}
