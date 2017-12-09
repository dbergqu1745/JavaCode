package lab9;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 9 - Rectangle class
 * Due 11/2/17
 */

public class Rectangle implements Shape{
	private double length;
	private double width;
	
	public Rectangle(double l, double w) {
		length = l;
		width = w;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double area() {
		return this.length * this.width;
	}
}
