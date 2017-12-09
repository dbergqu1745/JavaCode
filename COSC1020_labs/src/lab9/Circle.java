package lab9;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 9 - Circle class
 * Due 11/2/17
 */

public class Circle implements Shape {
	private double radius;
	
	public Circle(double r) {
		radius = r;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double r) {
		this.radius = r;
	}
	
	public double area() {
		return Math.PI * Math.pow(this.radius, 2);
	}
}
