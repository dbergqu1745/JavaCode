package lec11_13_17;

//Question 4
//Show your corrections for the compareTo method in the class Double2
class Double2 implements Comparable {
	private double value;

	public Double2(double theValue) {
		value = theValue;
	}

	public int compareTo(Object other) {
		Double2 dobj = (Double2) other;
		double dif = this.value - dobj.value;
		
		if (0 < dif && dif < 1) {
			return (int) Math.ceil(dif);
		} else {
			return (int) Math.floor(dif);
		}
	}

	public double doubleValue() {
		return value;
	}

	public static void main(String[] args) {
		Double2 d1 = new Double2(19.9);
		Double2 d2 = new Double2(20.0);

		System.out.println(d1.compareTo(d2));
	}
}
