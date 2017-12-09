package lab1;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Due 9/7/17
 * Lab 1 - PizzaOrder
 */
public class PizzaOrder {
	private int orderSize;
	private Pizza pizza1;
	private Pizza pizza2;
	private Pizza pizza3;
	
	public void setNumPizzas(int numPizzas) {
		if (numPizzas > 3 || numPizzas < 1) {
			System.out.println("Invalid order amount");
			System.exit(0);
		} else {
			this.orderSize = numPizzas;
		}
	}
	
	
	//Constructors
	PizzaOrder(Pizza za) {
		pizza1 = za;
		pizza2 = null;
		pizza3 = null;
	}
	
	PizzaOrder(Pizza za1, Pizza za2) {
		pizza1 = za1;
		pizza2 = za2;
		pizza3 = null;
	}
	
	PizzaOrder(Pizza za1, Pizza za2, Pizza za3) {
		pizza1 = za1;
		pizza2 = za2;
		pizza3 = za3;
	}
	
	//Setters
	public void setPizza1(Pizza za1) {
		this.pizza1 = za1;
	}
	
	public void setPizza2(Pizza za2) {
		this.pizza2 = za2;
	}
	
	public void setPizza3(Pizza za3) {
		this.pizza3 = za3;
	}
	
	//Methods
	/*calcTotal():
	 *Returns the total cost of an order
	 */
	public double calcTotal() {
		double total = 0;
		
		total += this.pizza1.calcCost();
		
		if (this.pizza2 != null) {
			total += this.pizza2.calcCost();
		}
		if (this.pizza3 != null) {
			total += this.pizza3.calcCost();
		}
		
		return total;
	}
	
	/*
	 * printReceipt():
	 * Prints the descriptions of all the pizzas in the order
	 */
	public void printReceipt() {
		System.out.println(this.pizza1.getDescription());
		
		if ( this.pizza2 != null) {
			System.out.println(this.pizza2.getDescription());
		}
		if (this.pizza3 != null) {
			System.out.println(this.pizza3.getDescription());
		}
	}
}
