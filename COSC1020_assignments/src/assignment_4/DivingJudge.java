package assignment_4;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Assignment 4 - Diving Judge class 
 * Due 11/17/17
 */

public class DivingJudge {

	public static double findMax(ArrayList<Double> list) {
		double max = list.get(0);
		int len = list.size();

		for (int i = 1; i < len; i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}

		return max;
	}

	public static double findMin(ArrayList<Double> list) {
		double min = list.get(0);
		int len = list.size();

		for (int i = 1; i < len; i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}
		}

		return min;
	}

	public static double computeScore(ArrayList<Double> scores, double difficulty) {
		double min = DivingJudge.findMin(scores);
		double max = DivingJudge.findMax(scores);
		double total = 0;

		scores.remove(min);
		scores.remove(max);
		scores.trimToSize();

		for (Double d : scores) {
			total += d;
		}

		return difficulty * total * .6;

	}

	public static void main(String[] args) {
		ArrayList<Double> scores = new ArrayList<Double>();
		String outer = "";
		double difficulty;
		int judges;
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to the dive judging program");

		do {
			System.out.println("Enter the number of judges:");
			judges = in.nextInt();
			
			System.out.println("Enter the diver's degree of difficulty:");
			difficulty = in.nextDouble();
			
			for (int i = 0; i < judges; i++) {
				System.out.println("Enter the score from judge #" + (i + 1) + " (between 0 and 10 inclusive)");
				scores.add(in.nextDouble());
			}
			
			System.out.println("The diver's final score is " + DivingJudge.computeScore(scores, difficulty));
			
			System.out.println("Would you like to judge another set of dives? (respond with y/n)");
			outer = in.next();
			
		} while (outer.equals("y"));
		
		System.out.println("Goodbye");
		
		in.close();
	}
}
