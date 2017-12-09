/*
 *Daniel Bergquist
 *daniel.bergquist@marquette.edu
 *8/29/17
 *Simple test program 
 */

import java.util.Scanner;

public class Test {
	
	public void printNums(int end) {
		for (int i = 0; i < end; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		
		Scanner read = new Scanner(System.in);
		System.out.println("Enter a number: ");
		
		int end = read.nextInt();
		test.printNums(end);
	}
}
