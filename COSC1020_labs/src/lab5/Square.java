package lab5;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 5 - Square Class
 * due 9/28/17
 */

//Square is child of shape
public class Square extends Shape{
	//private double size;
	
	public Square() {
		super(1);
	}
	
	public Square(double a) {
		super(a);
	}

	//area of square
	public double getArea() {
		return size * size;
	}
	
	//perimeter of square
	public double getPerimeter() {
		return size * 4;
	}
	
	
}
