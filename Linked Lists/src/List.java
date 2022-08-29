
public class List {

/**
 * AC12001/AC22007 Lab 1 Starting files
 * 
 * @author Computing, School of Science and Engineering, University of Dundee.
 *         Note. Change this comment to describe this class and add your name!
 * @version v1.0
 */
    private ListNode head; // used to hold a reference to an instance of a ListNode object
    // which will be the first item in the list, i.e. at the 'head'
    // of the list

    /**
     * Default constructor. Initialise fields to default values.
     */
    public List()
    {
        // set the list to be empty, i.e. not referring to anything valid yet
        head = null;
    }

    /**
     * Get the list node which is at the 'head' of the list
     * 
     * @return A reference to a ListNode object which represents the node at the
     *         head of the list (or null if the list is empty, i.e. no 'head' has
     *         been set yet).    
     */
    public ListNode getHead()
    {
        return head;
    }

    /**
     * Set the 'head' of the list to the given node
     * 
     * @param  newHead A reference to a ListNode object which will be
     *                 the head of the list. 
     *                 
     * NOTE: if a list already exists, the existing listing will be 
     * lost since the head is being assigned to something new.
     */
    public void setHead(ListNode newHead)
    {
        head = newHead;
    }

    /**
     * Add a new node to the start of the list which will contain
     * the data provided (a student ID and mark).
     * 
     * @param id The id of the student to be placed in this list node
     * @param mark The student's mark 
     */
    public void addToList(String id, int mark)
    {
        ListNode newNode;
        newNode = new ListNode(id,mark);
        newNode.setNext(head);
        head = newNode;
    	// TODO: add code here to add a new node to the list
        // See the Lecture slides for an example
    }

    // ########
    // TODO: ADD OTHER METHODS HERE, E.G. TO PRINT THE CONTENTS OF THE
    // LIST AND TO FIND STUDENTS IN THE LIST
    // ########
    
    public void printList(String id, int mark) 
    {
    	ListNode marker = null;
    	marker = head;
    	
    	while(marker != null) 
    	{
    		System.out.println(id);
    		System.out.println(mark);
    		marker.setNext(head);
    	}
    	
    }
}
