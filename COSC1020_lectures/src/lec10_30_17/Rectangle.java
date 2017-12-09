package lec10_30_17;

import java.util.Arrays;

/*
 * Both abstract classes and interfaces:
 * 	you don't have to provide the logic for methods
 * Differences between abstract classes and interfaces:
 * 	interfaces must have final static instance variables, abstract classes can have normal instance variables
 */

public class Rectangle implements Comparable {
	private int length;
	private int width;

	public Rectangle(int len, int wid) {
		length = len;
		width = wid;
	}
	
	
//	@Override
//	//Ascending order
//	public int compareTo(Object o) {
//		//This 
//		Rectangle r = (Rectangle) o;
//		
//		int thisArea = this.length * this.width;
//		int objectArea = r.length * r.width;
//		
////		//verbose version
////		if (thisArea > objectArea) return 1;
////		
////		else if (thisArea < objectArea) return -1;
////		
////		return 0;
//		
////		//quick version
//		return thisArea - objectArea;
//	}
	
	
	@Override
	//Descending order
	public int compareTo(Object o) {
		//This 
		Rectangle r = (Rectangle) o;
		
		int thisArea = this.length * this.width;
		int objectArea = r.length * r.width;
		
//		// Verbose version
//		if (thisArea > objectArea) return -1;
//		
//		else if (thisArea < objectArea) return 1;
//		
//		return 0;
		
		return objectArea - thisArea;
	}
	
	public static void main(String[] args) {
		Rectangle[] rectangles = new Rectangle[4];
	
		
		
		rectangles[0] = new Rectangle(10, 10);
		rectangles[1] = new Rectangle(9, 8);
		rectangles[2] = new Rectangle(4, 3);
		rectangles[3] = new Rectangle(1, 2);
	
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i].length * rectangles[i].width);
		}
		
		Arrays.sort(rectangles);
		System.out.println();
		
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i].length * rectangles[i].width);
		}
	}

}
