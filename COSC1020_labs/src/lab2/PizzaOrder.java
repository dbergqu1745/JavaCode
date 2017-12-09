package lab2;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 9/7/17
 * Lab 2 - PizzaOrder
 */
public class PizzaOrder implements Order {
	private int orderSize;
	private Pizza[] pizzas; 	
	
	//Constructors
	public PizzaOrder(int size) {
		pizzas = new Pizza[size];
		orderSize = size;
	}
	
	//Setters
	//Sets a pizza at a specific index
	public void setNumPizzas(int index, Pizza pizza) {
		if (index < pizzas.length && index >= 0) {	
			pizzas[index] = pizza;
		} else {
			System.out.println("ERROR: INVALID INDEX");
			System.exit(0);
		}
	}
	
//	//Resizes order
//	public void setNumPizzas(int size) {
//		Pizza[] newOrder = new Pizza[size];
//		
//		for (int i = 0; i < orderSize; i++) {
//				newOrder[i] = pizzas[i];
//		}
//		
//		this.pizzas = newOrder;
//	}
	
	//Methods
	/*calcTotal():
	 *Returns the total cost of an order
	 */
	public double calcTotal() {
		double total = 0;
		
		for (int i = 0; i < orderSize; i++) {
			total += pizzas[i].calcCost();
		}
		
		return total;
	}
	
	/*
	 * printReceipt():
	 * Prints the descriptions of all the pizzas in the order
	 */
	public void printReceipt() {
		for (int i = 0; i < orderSize; i++) {
			pizzas[i].getDescription();
		}	
	}
}
