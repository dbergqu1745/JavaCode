package lec8_30_17;

import java.util.Scanner;

public class TestStudent {
	
	public static void main(String[] args) {
		Student student = new Student();
		Student student2 = new Student();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the student's name: ");
		String name = scan.nextLine();
		
		
		System.out.println("Enter the student's ID number: ");
		String ID = scan.nextLine();
		
		System.out.println("Enter the student's major: ");
		String major = scan.nextLine();
		
		
		student.setId(ID);
		student.setName(name);
		student.setMajor(major);
		
		System.out.println("Enter the student's name: ");
		name = scan.nextLine();
		
		
		System.out.println("Enter the student's ID number: ");
		ID = scan.nextLine();
		
		System.out.println("Enter the student's major: ");
		major = scan.nextLine();
		
		student2.setId(ID);
		student2.setName(name);
		student2.setMajor(major);
		
		System.out.println(student.toString());
		System.out.println(student2.toString());
		System.out.println(student.equals(student2));
		scan.close();
		
	}

}
