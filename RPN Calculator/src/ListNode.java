
public class ListNode {
	
    // fields to store the data being held in this list node
    private double number;
    private ListNode next;  

    /**
     * Default constructor. Initialise fields to default values
     */
    public ListNode()
    {
        // set number to default / empty values 
        number = 0;
        next = null;
        
    }

    /**
     * Alternative constructor.
     *
     */
    public ListNode(double number)
    {
        // set id and mark to values provided
        this.number = number;
        next = null;
       
    }

    /**
     * Get the number contained in this list node
     * 
     */
    public double getNumber()
    {
        return number;
    }

    /**
     * Get the next node in the list after this one
     * 
     */
    public ListNode getNext()
    {
       return next;
    }

    /**
     * Set the next node in the list after this one
     * 
     */
    public void setNext(ListNode node)
    {
    	next = node;
    }

}


