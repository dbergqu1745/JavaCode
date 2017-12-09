package Midterm_2;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Midterm 2 - employee class
 * due 11/15/17
 */

public class Employee implements Comparable, Cloneable{
	private String name;
	private int id;

	public Employee() {
		name = null;
		id = 0;
	}

	public Employee(String aName, int aId) {
		name = aName;
		id = aId;
	}
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int compareTo(Object obj) {
		Employee emp = (Employee) obj;
		
//		//compare employees IDs
		return this.id - emp.id;
	
		//compare employees names
//		return this.name.compareTo(emp.name);
	}
}
