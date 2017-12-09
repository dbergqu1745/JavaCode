package lec12_6_17;

public class ThreadedAdder implements Runnable{
	private Thread t;

	private int lowerBound;
	private int upperBound;
	
	public ThreadedAdder(int a, int b) {
		lowerBound = a;
		upperBound = b;
		System.out.println("Thread with bounds " + (lowerBound + 1) + " and " + (upperBound + 1) + " created.");
		
	}
	
	@Override
	public void run() {
		int a = this.lowerBound;
		int b = this.upperBound;
		
		for (int i = a; i < b; i++) {
			
		}
		
		
	}
	
	public void start() {
		
	}

}
