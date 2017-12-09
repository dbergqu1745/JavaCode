package lab9;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 9 - Testing shapes
 * Due 11/2/17
 */

public class ShapeTest {
	public static void main(String[] args) {
		Circle c = new Circle(9);
		Rectangle r = new Rectangle(5, 3);
		
		System.out.println("Circle area: " + c.area());
		System.out.println("Rectangle area: " + r.area());
	}
}
