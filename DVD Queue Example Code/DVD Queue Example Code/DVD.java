
/**
 * Stores information about a DVD
 * @author Iain Martin
 * @version 1.0
 */
public class DVD
{
    private String title; // the title of the DVD, e.g. movie title
    private String leadActor; // the name of the lead actor

    /**
     * Default constructor. Initialise fields to default values.
     */
    public DVD()
    {
        title = "";
        leadActor = "";
    }

    /**
     * Alternative constructor. Initialise fields to given values.
     * 
     * @param title The title for the DVD
     * @param leadActor The name of the lead actor
     */
    public DVD(String title, String leadActor)
    {
        this.title = title;
        this.leadActor = leadActor;
    }
    
    /**
     * Get the title of the DVD
     * 
     * @return the DVD title as a String
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Get the name lead of the actor of the DVD
     * 
     * @return the name of the lead actor of the DVD as a String
     */
    public String getLeadActor()
    {
        return leadActor;
    }
    
    /**
     * Set the title of the DVD
     * 
     * @param title The title to give the DVD
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Set the name lead of the actor of the DVD
     * 
     * @param leadActor The name of the lead actor for the DVD
     */
    public void setLeadActor(String actor)
    {
        this.leadActor = actor;
    }
}
