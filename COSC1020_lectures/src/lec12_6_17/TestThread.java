package lec12_6_17;

public class TestThread {

	public static void main(String args[]) {
		ThreadDemo R1 = new ThreadDemo("Thread One");
		R1.start();

		ThreadDemo R2 = new ThreadDemo("Thread Two");
		R2.start();
	}
}
