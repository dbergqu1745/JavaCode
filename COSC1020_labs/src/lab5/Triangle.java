package lab5;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 5 - Triangle Class
 * due 9/28/17
 */

//triangle is child of shape
public class Triangle extends Shape {
	//double size;
	
	public Triangle() {
		super(1);
	}
	
	public Triangle(double s){
		super(s);
	}
	
	//perimeter of equilateral triangle
	public double getPerimeter(){
		return 3 * size;
	}
	
	//area of equilateral triangle
	public double getArea(){
		return size * size * (Math.sqrt(3))/4.0;
	} 
}
