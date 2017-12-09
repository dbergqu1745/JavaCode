package assignment_2;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Assignment 2 - Rational Number class
 * Due 9/22/17
 */

public class RationalNumber {
	private int numerator;
	private int denominator;
	
	//Constructors
	public RationalNumber() {
		numerator = 0;
		denominator = 1;
		
	}
	
	public RationalNumber(int a) {
		numerator = a;
		denominator = 1;
		
	}
	
	public RationalNumber(int a, int b) {
		if (b < 0) {	
			numerator = a * -1;
			denominator = b * -1;
		} else {
			numerator = a;
			denominator = b;
		}
		
	}

	//Getters and Setters
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	//Methods
	/*
	 *For the secondary add, subtract, multiply, and divide methods, I elected to 
	 *implement 'Alternate Part 2' as described in the textbook
	 */
	public static void flip(RationalNumber rn) {
		int temp = rn.numerator;
		rn.numerator = rn.denominator;
		rn.denominator = temp;
	}
	
	public String toString() {
		return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
	}
	
	public static void reduce(RationalNumber rn) {
		boolean isFlipped = false;
		int num = rn.numerator;
		int den = rn.denominator;
		int rem = 0;
		
		if (rn.numerator > rn.denominator) {
			flip(rn);
			isFlipped = true;
		}
		
		//finding the GCD
		do {
			rem = den % num;
			den = num;
			num = rem;
		} while (rem != 0);
		
		if (isFlipped) {
			flip(rn);
		}
		
		rn.setNumerator(rn.numerator / den);
		rn.setDenominator(rn.denominator / den);
	}
	
	public boolean equals(RationalNumber rn) {
		return (this.numerator == rn.numerator) && (this.denominator == rn.denominator);
	}
	
	public boolean isEquivalent(RationalNumber rn) {
		if (this.equals(rn)) {
			return true;
		} else {
			if (this.numerator > rn.numerator) {
				return (this.numerator % rn.numerator == 0) && (this.denominator % rn.denominator == 0);
			} else {
				return (rn.numerator % this.numerator == 0) && (rn.denominator % this.denominator == 0);
			}
		}
	}
	
	//Two-parameter add
	public static RationalNumber add(RationalNumber rn1, RationalNumber rn2) {
		RationalNumber rn = new RationalNumber();
		int num = 0; 
		int den = 0;
		
		num = (rn1.numerator * rn2.denominator) + (rn1.denominator * rn2.numerator);
		den = rn1.denominator * rn2.denominator;
		
		rn.setNumerator(num);
		rn.setDenominator(den);
		
		reduce(rn);
		
		return rn;
	}

	//Calling object add
	public void add(RationalNumber rn) {
		int num = 0; 
		int den = 0;
		
		num = (this.numerator * rn.denominator) + (this.denominator * rn.numerator);
		den = this.denominator * rn.denominator;
		
		this.setNumerator(num);
		this.setDenominator(den);
		
		reduce(this);
	}
	
	//Two-parameter subtract
	public static RationalNumber subtract(RationalNumber rn1, RationalNumber rn2) {
		rn2.setNumerator(-1 * rn2.numerator);
		
		return add(rn1, rn2);
	}
	
	//Calling object subtract
	public void subtract(RationalNumber rn) {
		rn.setNumerator(-1 * rn.numerator);
		
		this.add(rn);
	}
	
	
	//Two-parameter multiply
	public static RationalNumber multiply(RationalNumber rn1, RationalNumber rn2) {
		RationalNumber retRN = new RationalNumber();
		
		retRN.setNumerator(rn1.numerator * rn2.numerator);
		retRN.setDenominator(rn1.denominator * rn2.denominator);
		
		reduce(retRN);
		
		return retRN;
	}
	
	//Calling object multiply
	public void multiply(RationalNumber rn) {
		this.setNumerator(this.numerator * rn.numerator);
		this.setDenominator(this.denominator * rn.denominator);	
	}
	
	//Two-parameter divide
	public static RationalNumber divide(RationalNumber rn1, RationalNumber rn2) {
		flip(rn2);
		return multiply(rn1, rn2);
	}
	
	//Calling object divide
	public void divide(RationalNumber rn) {
		this.setNumerator(this.numerator * rn.denominator);
		this.setDenominator(this.denominator * rn.numerator);
		reduce(this);
	}
}
