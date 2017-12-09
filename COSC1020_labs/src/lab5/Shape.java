package lab5;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 5 - Shape Class
 * due 9/28/17
 */

//abstract parent class of shape
public abstract class Shape {
	protected double size;
	
	public Shape() {
		size = 1;
	}
	
	public Shape(double a) {
		size = a;
	}
	
	public String toString() {
		return "" + this.getClass().getName() + " has size " + this.size;
	}
	
	//must be abstract to be extended in child classes
	public abstract double getArea();
	
	//must be abstract to be extended in child classes
	public abstract double getPerimeter();
}
