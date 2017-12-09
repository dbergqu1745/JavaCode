package assignment_4;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Assignment 4 - Employee class
 * Due 11/17/17
 */

public class Employee implements Cloneable {
	private int idNumber;
	private String name;
	
	public Employee(int idNumber, String name) {
		super();
		this.idNumber = idNumber;
		this.name = name;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	public String getName() {
		return name;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return (Employee)super.clone();
	}
	
	public static void main(String[] args) {
		Employee emp = new Employee(123, "Daniel Bergquist");
		
		try {
			
			Employee emp2 = (Employee)emp.clone();
			
			System.out.println(emp2.getIdNumber());
			System.out.println(emp2.getName());
			
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
}
