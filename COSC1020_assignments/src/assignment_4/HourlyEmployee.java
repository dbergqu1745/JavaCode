package assignment_4;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Assignment 4 - Hourly Employee class
 * Due 11/17/17
 */

public class HourlyEmployee extends Employee {
	private double wage;

	public HourlyEmployee(int idNumber, String name, double wage) {
		super(idNumber, name);
		this.wage = wage;
	}
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public Object clone() throws CloneNotSupportedException {
		return (HourlyEmployee)super.clone();
	}
	
	public static void main(String[] args) {
		HourlyEmployee hourlyEmp = new HourlyEmployee(123, "Daniel Bergquist", 8.5);
		
		try {
			
			HourlyEmployee hourlyEmp2 = (HourlyEmployee)hourlyEmp.clone();
			System.out.println(hourlyEmp2.wage);
			System.out.println(hourlyEmp2.getIdNumber());
			System.out.println(hourlyEmp2.getName());
			
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
