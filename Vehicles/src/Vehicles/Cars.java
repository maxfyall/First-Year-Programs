package Vehicles;
import java.util.Scanner;

public class Cars {

	private String make;
	private String model;
	private int fuelTankSize;
	private int numberOfWheels;
	private double milesPerGallon;
	private int range;
//	range means the maximum amount of miles the car can travel on a full tank
	
	public Cars()
	{
		numberOfWheels = 4;
	}
	
	public void getinfo(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("What is the make of your Car?");
		make = s.nextLine();
		
		System.out.println("What is the model of your Car?");
		model = s.nextLine();
		
		System.out.println("What is the size of the car's fuel tank? (Litres)");
		String fuelTankSize_1 = s.nextLine();
		fuelTankSize = Integer.parseInt(fuelTankSize_1);
		
		System.out.println("What is the miles per gallon of the Car?");
		String milesPerGallon_1 = s.nextLine();
		milesPerGallon = Double.parseDouble(milesPerGallon_1);
		
		System.out.println("What is the maximum range of your Car? (Miles)");
		String range_1 = s.nextLine();
		range = Integer.parseInt(range_1);
		
		s.close();
		System.out.println("Model: " + model);
		System.out.println("Make: " + make);
		System.out.println("Size of Fuel Tank: " + fuelTankSize);
		System.out.println("Number of Wheels: " + numberOfWheels);
		System.out.println("MPG: " + milesPerGallon);
		System.out.println("Range: " + range);
	
		}
}
