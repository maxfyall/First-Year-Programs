package inheritance;

public class Photographer extends Competitor{

	private String entryCatagory;
	private String comment;
	
	public Photographer() {
		
		super();
		entryCatagory = "45";
		comment = "Not Bad";
	}
	
	/**
	 * @return the entryCatagory
	 */
	public String getEntryCatagory() {
		entryCatagory= "45";
		return entryCatagory;
	}
	/**
	 * @param entryCatagory the entryCatagory to set
	 */
	public void setEntryCatagory(String entryCatagory) {
		entryCatagory = "45";
		this.entryCatagory = entryCatagory;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		comment = "Not Bad";
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		comment = "Not bad";
		this.comment = comment;
	}
	
	public void displayPhotographerFields() {
		
		super.displayCompetitorFields();
		System.out.println("Entry Catagory:" + entryCatagory);
		System.out.println("Comment:" + comment);
	}

}
