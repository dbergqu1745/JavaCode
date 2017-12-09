package lec9_11_17;

/*
 * Practicing copy constructors
 */
public class Basic {
	private int field1, field2;
	
	//Constructors
	public Basic(int f) {
		field1 = f;
		field2 = 0;
	}
	
	public Basic(int f1, int f2) {
		field1 = f1;
		field2 = f2;
	}
	
	//Copy constructor
	Basic(Basic b){
		System.out.println("COPY");
		field1 = b.field1;
		field2 = b.field2;
	}
	
	public void printBasic() {
		System.out.println(this.field1 + "  " + this.field2);
	}
	
	public static void main(String[] args) {
		Basic b1 = new Basic(1, 2);
		Basic b2 = new Basic(b1);
		
		b1.printBasic();
		b2.printBasic();
	}

}
