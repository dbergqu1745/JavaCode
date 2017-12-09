package Midterm_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Midterm 2 - file reader class
 * due 11/15/17
 */

public class FileReader {
	
	public static ArrayList<Employee> readEmployeeFile(String fileName) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		File f;
		Scanner in;
		String name;
		int idNum;
		
		try {
			
			f = new File(fileName);
			in = new Scanner(f);
			
			while (in.hasNext()) {
				
				name = in.next();
				idNum = in.nextInt();
				
				employees.add(new Employee(name, idNum));
			}
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		return employees;	
	}

	/*
	 * Returns an arrayList of only those Employees objects whose id is less than
	 * 100.
	 */
	public static ArrayList<Employee> chooseEmployees(ArrayList<Employee> empList) {
		ArrayList<Employee> resultList = new ArrayList<Employee>();
		Employee emp;
		int len = empList.size();
		
		for (int i = 0; i < len; i++) {
			emp = empList.get(i);
			
			if (emp.getId() < 100) {
				resultList.add(emp);
			}
		}
		
		return resultList;		
	}
	
//	Used for testing
//	public static void main(String[] args) {
//		ArrayList<Employee> emps = FileReader.readEmployeeFile("employee.txt");
//		
//		for (Employee e : emps) {
//			System.out.println(e.getName() + " " + e.getId());
//		}
//		
//		ArrayList<Employee> selectedEmps = FileReader.chooseEmployees(emps);
//		
//		System.out.println();
//		
//		for (Employee e : selectedEmps) {
//			System.out.println(e.getName() + " " + e.getId());
//		}
//	}

}
