package Final_Exam;

/*
 * Daniel Bergquist
 * daniel.bergquist@marquette.edu
 * Final Exam - threaded PrintWord
 * due 12/14/17
 */

public class PrintWord extends Thread {
	private String word;
	private int times;
	
	public PrintWord(String s, int n) {
		word = s;
		times = n;
	}
	
	public void run() {
		int t = this.times;
		String s = this.word;
		
		for (int i = 0; i < t; i++) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		PrintWord hello = new PrintWord("hello", 20);
		PrintWord world = new PrintWord("world", 10);
		
		hello.start();
		world.start();
	}
}
