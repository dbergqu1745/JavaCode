package linkedLists;

public class Node {
	int data;
	Node next, previous;
	
	public Node(int d) {
		data = d;
		next = null;
		previous = null;
	}
	
	public Node() {
		next = null;
		previous = null;
	}
}
