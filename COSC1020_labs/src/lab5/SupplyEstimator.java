package lab5;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 5 - SupplyEstimator Class
 * due 9/28/17
 */

public class SupplyEstimator {
	
	static Shape[] shapeList = {
		new Triangle(4.0),
		new Triangle(2.5),
		new Triangle(2.5),
		new Square(),
		new Triangle(10.0),
		new Hexagon(3.9),
		new Square(3.3),
		new Triangle(7.0),
		new Hexagon(),
		new Triangle()};
	
	public static void main(String[] args){
		double perrymeter = 0.0; //Perry loves puns
		double area = 0.0;
		for (int i = 0; i < shapeList.length; i++) {

			perrymeter += shapeList[i].getPerimeter();
			area += shapeList[i].getArea();
			System.out.println(shapeList[i].toString()); //printing out the class of each object
		}
		
		System.out.println("For the " + shapeList.length + " shapes given");
		System.out.println("the total perimeter is "+ perrymeter);
		System.out.println("and the total area is "+ area);
	}	
}

