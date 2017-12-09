package lab3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 3 - Vehicle Class
 * due 9/21/17
 */

public class Vehicle {
	private int numWheels;
	private double milesPerGallon;
	
	//getters
	public int getNumWheels() {
		return numWheels;
	}
	public double getMilesPerGallon() {
		return milesPerGallon;
	}
	
	//setters
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
	public void setMilesPerGallon(double milesPerGallon) {
		this.milesPerGallon = milesPerGallon;
	}
	
	//constructors
	public Vehicle(int wheels, double mpg) {
		numWheels = wheels;
		milesPerGallon = mpg;
	}
	
	//Methods
	public String toString() {
		return "This vehicle has " + Integer.toString(numWheels) + " wheels and gets " + Double.toString(milesPerGallon) + " miles to the gallon.";
	}
	
	public boolean equals(Vehicle veh) {
		return this.getNumWheels() == veh.getNumWheels() && (Math.abs(this.getMilesPerGallon() - veh.getMilesPerGallon()) < .0001);
	}
}
