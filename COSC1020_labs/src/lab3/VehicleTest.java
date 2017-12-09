package lab3;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 3 - Driver program
 * due 9/21/17
 */

public class VehicleTest {

	public static void main(String[] args) {
		Vehicle car1 = new Car(35);
		Vehicle car2 = new Car(35);
		
		Vehicle moto1 = new Car(35);
		Vehicle moto2 = new Car(25);
		
		Vehicle veh = new Vehicle(7, 90);
		
		System.out.println("Car one info: " + car1);
		System.out.println("Car two info: " + car2 + '\n');
		
		System.out.println("Motorcycle one info: " + moto1);
		System.out.println("Motorcycle two info: " + moto2 + '\n');
		
		if (car1.equals(car2)) {
			System.out.println("Car one and car two are the same");
		} else {
			System.out.println("Car one and car 2 are different");
		}
		
		if (moto1.equals(moto2)) {
			System.out.println("Motorcycle one and Motorcycle two are the same\n");
		} else {
			System.out.println("Motorcycle one and Motorcycle 2 are different\n");
		}
		
		System.out.println(veh);
	}
	

}
