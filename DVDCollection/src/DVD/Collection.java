package DVD;

import java.util.Scanner;

public class Collection {
	
	/**Assigns 3 different DVDs and a string for the search method
	 * 
	 */
	private DVDClass CollectionDVD1 = new DVDClass();
	private DVDClass CollectionDVD2 = new DVDClass();
	private DVDClass CollectionDVD3 = new DVDClass();
	private String searchFilm;
	
/** main method
 * 	
 * @param args
 * 
 */
	public static void main(String[] args) {
		
		Collection collectionData = new Collection();
		collectionData.setData();
		
		collectionData.displayDVDs();
		collectionData.searchDataBase();
		System.out.println("END OF PROGRAM");
		System.exit(0);
	}
	
	/** Set values for the three DVDS in the Collection
	 * 
	 */
	public void setData() {
		
		CollectionDVD1.getInfo();
		CollectionDVD2.getInfo();
		CollectionDVD3.getInfo();
		

	}
	
	/**Displays the information about the DVDS the user entered
	 * 
	 */
	public void displayDVDs() {
		
		CollectionDVD1.displayValues();
		CollectionDVD2.displayValues();
		CollectionDVD3.displayValues();
	}
	
	/**Allows the user the search the Collection of DVDS to see if a DVD is present in the collection
	 * 
	 */
	public void searchDataBase() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a Name of a Film you would like to search in our Collection");
		searchFilm = s.nextLine();
		
		s.close();
		
		if (searchFilm.equals(CollectionDVD1));{
			System.out.println("The film you entered is in out database");
		}
		
		if (searchFilm.equals(CollectionDVD2));{
			System.out.println("The film you entered is in out database");
		}
		
		if (searchFilm.equals(CollectionDVD3));{
			System.out.println("The film you entered is in out database");
		}
	}
}
