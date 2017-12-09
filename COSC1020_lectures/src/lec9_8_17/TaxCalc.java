package lec9_8_17;

public class TaxCalc {
	
	public static double calcTax(double income) {
		
		if (income >= 0 && income <= 15000) {
			return income * .10;
		} else if (income > 15000 && income < 30000) {
			income -= 15000;
			return (15000 * .1) + income * .15;
		} else if (income >= 30000) {
			income -= 30000;
			return (15000 * .1) + (15000 * .15) + income * .2;
		}
		
		return 0;
	}
}
