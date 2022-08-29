package inheritance;

public class Competitor {

	private String name;
	private String address;
	
	public Competitor() {
		
		name = "Bob";
		address = "123 Drive Lane";
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		name = "bob";
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		name = "bob";
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		address = "123 Drive Lane";
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		address = "123 Drive Lane";
		this.address = address;
	}
	
	public void displayCompetitorFields() {
		
		System.out.println("Name:" + name);
		System.out.println("Address:" + address);
	}
	
 }
