package lab5;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 5 - Hexagon Class
 * due 9/28/17
 */

//hexagon is child of shape
public class Hexagon extends Shape{
	//private double size;
	
	public Hexagon() {
		super(1);
	}
	
	public Hexagon(double a) {
		super(a);
	}
	
	//perimeter of equilateral hexagon
	public double getPerimeter() {
		return size * 6;
	}
	
	//area of equilateral hexagon
	public double getArea() {
		return 1.5 * (Math.pow(size * 3, .5));
	}
}
