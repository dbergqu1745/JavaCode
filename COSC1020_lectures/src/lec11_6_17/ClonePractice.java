package lec11_6_17;

public class ClonePractice {
}

class StockItem implements Cloneable {
	private int number;
	private String name;

	public void setNumber(int newNumber) {
		number = newNumber;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}

class PriceItem extends StockItem implements Cloneable {
	private double price;

	public Object clone() {
		return super.clone();
	}

}

class Record {
	private StockItem item1;
	private StockItem item2;
	private String description;

	public Object clone() {
		try {
			Record copy = (Record) super.clone();
			copy.item1 = (StockItem) item1.clone();
			copy.item2 = (StockItem) item2.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
