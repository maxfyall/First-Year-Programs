
public class List {

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
     */
    public ListNode getHead()
    {
        return head;
    }

    /**
     * Set the 'head' of the list to the given node
     * 
     *                 
     */
    public void setHead(ListNode newHead)
    {
        head = newHead;
    }

    /**
     * Add a new node to the start of the list which will contain
     * the data provided (the number in the stack).
     * 
     */
    public double addToList(double number)
    {
        ListNode newNode; // creates instance of ListNode class 
        newNode = new ListNode(number); // adds data to new Node
        newNode.setNext(head);
        head = newNode; // sets the new node as the top of the stack
        
        return number;
    }

    /**
     * Method for deleting numbers from the top of the stack
     * 
     */
	public double deleteFromStack(double num, double number) 
	{
		num = head.getNumber(); // sets the data in the top node to the field num
		ListNode newHead = head.getNext(); // makes new head by setting head to 2nd item in stack deleting the 1st item.
		setHead(newHead);
		
		return num; // returns the data stored
	}
    
	/**
	 * Method to check if the stack is empty
	 * @param condition 
	 */
    public boolean isListempty(boolean condition)
    {
    	
    	boolean found = false;
    	
    	ListNode marker = null; // creates instance of ListNode and sets to null
    	marker = head; // sets object reference to the top of list
    	
    	if(marker == null)
    	{
    		System.out.println("The list is clear"); // tells user the list is empty.
    		found = true;
    	}
    	else
    	{
    		System.out.println("The list has data in it, an error may have occured"); // tells user the list has data in it.
    		System.out.println("Press enter to continue");
    		deleteFromStack(0, 0);
    	}
    	
    	return found;
    }
}
