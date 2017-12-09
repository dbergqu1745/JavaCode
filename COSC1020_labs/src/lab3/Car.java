package lab3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 3 - Car Class
 * due 9/21/17
 */

public class Car extends Vehicle {

	public Car(double mpg) {
		super(4, mpg);
	}
	
	public String toString() {
		return "This car has " + Integer.toString(this.getNumWheels()) + " wheels and gets " + this.getMilesPerGallon() + " miles to the gallon.";
	}
}
