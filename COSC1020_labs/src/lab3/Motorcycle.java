package lab3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 3 - Motorcycle Class
 * due 9/21/17
 */

public class Motorcycle extends Vehicle{

	public Motorcycle(double mpg) {
		super(2, mpg);
	}
	
	public String toString() {
		return "This motorcycle has " + Integer.toString(this.getNumWheels()) + " wheels and gets " + this.getMilesPerGallon() + " miles to the gallon.";
	}
}
