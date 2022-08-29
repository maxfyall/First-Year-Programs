package FilesExcersie;

import java.util.Scanner;


public class Collection {
	
	DVD[] CollectionDVD = new DVD[2];
	
	public void setData() {
		
		CollectionDVD[0].getInfo();
		CollectionDVD[1].getInfo();
		CollectionDVD[2].getInfo();
	}
	
	/**Displays the information about the DVDS the user entered
	 * 
	 */
	public void displayDVDs() {
		
		CollectionDVD[0].displayValues();
		CollectionDVD[1].displayValues();
		CollectionDVD[2].displayValues();

	}
}
