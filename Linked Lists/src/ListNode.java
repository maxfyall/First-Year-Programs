
public class ListNode {

/**
 * AC12001/AC22007 Lab 1 Starting files
 * 
 * @author Computing, School of Science and Engineering, University of Dundee.
 *		   Note. Change this to comment to describe this class and add your name!
 * @version v1.0
 */
	
    // fields to store the data being held in this list node (a student ID and mark)
    private String id;
    private int mark;
    private ListNode next;
    
    // TODO: Add a field to store a reference to the next node in the list after this one
  

    /**
     * Default constructor. Initialise fields to default values
     */
    public ListNode()
    {
        // set id and mark to default / empty values 
        id = "";
        mark = 0;
        next = null;


        // TODO: set next node to null - no valid next node yet
        
    }

    /**
     * Alternative constructor. Set fields to given values.
     *
     * @param id The id for the student
     * @param mark The student's mark
     */
    public ListNode(String id, int mark)
    {
        // set id and mark to values provided
        this.id = id;
        this.mark = mark;
        next = null;

        // TODO: set next node to null - no valid next node yet
       
    }

    /**
     * Get the student ID contained in this list node
     * 
     * @return The student's ID as a String
     */
    public String getID()
    {
        return id;
    }

    /**
     * Get the student mark contained in this list node
     * 
     * @return The student mark
     */
    public int getMark()
    {
        return mark;
    }

    /**
     * Get the next node in the list after this one
     * 
     * @return A reference to the next node (or null if
     *         there is no next node)
     */
    public ListNode getNext()
    {
       return next;
    }

    /**
     * Set the next node in the list after this one
     * 
     * @param next A reference to a ListNode object which 
     *             represents the next node in the list after
     *             this one.
     */
    public void setNext(ListNode node)
    {
    	next = node;
    }

    /**
     * Return a string containing summary data from this node
     * 
     * @return A String containing a summary of the data contained in this list node
     */
    public String getSummaryData()
    {
        String data;		
        data = "Student with ID " + id + " obtained the following mark: " + mark + "%";		
        return data;
    }
}


