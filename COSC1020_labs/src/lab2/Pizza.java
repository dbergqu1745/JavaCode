package lab2;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 9/8/17
 * Assignment 1 - Pizza class
 */
public class Pizza {
	//Variables
	private String pizzaSize;
	private int numPepperoni, numCheese, numHam;
	
	//Size
	public String getSize() {
		return pizzaSize;
	}
	public void setSize(String size) {
		this.pizzaSize = size;
	}
	
	//numPepperoni
	public int getNumPepperoni() {
		return numPepperoni;
	}
	public void setNumPepperoni(int numPepperoni) {
		this.numPepperoni = numPepperoni;
	}
	
	//numCheese
	public int getNumCheese() {
		return numCheese;
	}
	public void setNumCheese(int numCheese) {
		this.numCheese = numCheese;
	}
	
	//numHam
	public int getNumHam() {
		return numHam;
	}
	public void setNumHam(int numHam) {
		this.numHam = numHam;
	}
	
	//Constructor
	public Pizza(String size, int cheese, int pepperoni, int ham) {
		pizzaSize = size;
		numCheese = cheese;
		numPepperoni = pepperoni;
		numHam	= ham;
	}
	
	//Methods
	/*calcCost
	 *returns total cost of a single pizza based on size and quantity of toppings
	 *<objectName>.calcCost()
	 */
	public double calcCost() {
		double toppingCost = (2 * this.numCheese) + (2 * this.numPepperoni) + (2 * this.numHam);
		
		if ((this.pizzaSize).equalsIgnoreCase("small")) {
			return 10 + toppingCost;
		} else if ((this.pizzaSize).equalsIgnoreCase("medium")) {
			return 12 + toppingCost;
		} else if ((this.pizzaSize).equalsIgnoreCase("large")) {
			return 14 + toppingCost;
		}
		
		return 0;
	}
	
	/*
	 *getDescription
	 *returns string listing all attributes of a single pizza and its cost truncated to two decimal places
	 *<objectName>.getDescription
	 */
	public String getDescription() {
		String pizzaCost = String.format("%.2f", this.calcCost());
		return "Size: " + this.pizzaSize + " | " + this.numCheese + "x Cheese | " + this.numPepperoni + "x Pepperoni | " + this.numHam + "x Ham | Cost: $" + pizzaCost;
	}
	
	
}
