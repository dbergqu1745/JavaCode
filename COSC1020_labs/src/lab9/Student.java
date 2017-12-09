package lab9;

import java.util.Arrays;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Lab 9 - Student class with main method and 
 *         two implementations of compareTo
 * Due 11/2/17
 */

public class Student implements Comparable {
	private String lastName;
	private int idNumber;
	
	public Student(String name, int id) {
		lastName = name;
		idNumber = id;
	}
	
	
	public String getLastName() {
		return lastName;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}



	@Override
	public int compareTo(Object obj) {
		Student s = (Student) obj;
		
		//Comparing based on lastName
		return this.lastName.compareToIgnoreCase(s.lastName);
		
//		//comparing based on id number
//		return this.idNumber - s.idNumber;
	}
	
	public static void printStudents(Student[] students) {
		int len = students.length;
		
		for (int i = 0; i < len; i++) {
			System.out.println("Student #" + (i + 1) + ": Last name: " + students[i].lastName + "| ID #: " + students[i].idNumber);
		}
	}
	
	public static void main(String[] args) {
		Student[] students = new Student[4];
		
		students[0] = new Student("Hunter", 12345);
		students[1] = new Student("Wick", 19873);
		students[2] = new Student("Bergquist", 29105);
		students[3] = new Student("Puri", 18353);
		
		Student.printStudents(students);
		System.out.println("\nSorting...\n");
		Arrays.sort(students);
		
		Student.printStudents(students);
	}

}
