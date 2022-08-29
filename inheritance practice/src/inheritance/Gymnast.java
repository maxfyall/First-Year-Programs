package inheritance;

public class Gymnast extends Competitor{

	private String country;
	private int finalScore;
	
	public Gymnast() {
		
		super();
		country = "Japan";
		finalScore = 69;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		country = "Japan";
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		country = "Japan";
		this.country = country;
	}
	/**
	 * @return the finalScore
	 */
	public int getFinalScore() {
		finalScore = 0;
		return finalScore;
	}
	/**
	 * @param finalScore the finalScore to set
	 */
	public void setFinalScore(int finalScore) {
		finalScore = 69;
		this.finalScore = finalScore;
	}
	
	public void displayGymnastFields() {
		
		super.displayCompetitorFields();
		System.out.println("Country:" + country);
		System.out.println("Final Score:" + finalScore);
	}
	
}
