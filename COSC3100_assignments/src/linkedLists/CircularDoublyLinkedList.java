package linkedLists;

public class CircularDoublyLinkedList {
	Node sentinel;
	
	public CircularDoublyLinkedList() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
	}
	
//	public CircularDoublyLinkedList(int a) {
//		sentinel = new Node();
//		Node node = new Node(a);
//		
//		node.previous = sentinel;
//		sentinel.next = node;
//		sentinel.previous = node;
//		node.next = sentinel;
//	}
	
	public void insertHead(int a) {
		//insert behind the sentinel
		Node node = new Node(a);
		
		sentinel.next.previous = node;
		node.previous = sentinel;
		node.next = sentinel.next;
		sentinel.next = node;
	}
	
	public void insertTail(int a) {
		Node node = new Node(a);
		
		node.previous = sentinel.previous;
		sentinel.previous.next = node;
		sentinel.previous = node;
		node.next = sentinel;
	}
	
	public void print() {
		Node temp = new Node();
		temp = this.sentinel.next;
		
		System.out.print("S <=> ");
		
		while (temp != sentinel) {
			System.out.print(temp.data + " <=> ");
			temp = temp.next;
		}
		
		System.out.print("S");
	}
	
	public static void main(String[] args) {
		CircularDoublyLinkedList list = new CircularDoublyLinkedList();
		list.insertHead(4);
		list.insertHead(8);
		list.insertHead(9);
		list.insertHead(890);
		list.print();
		
		System.out.println();
		
		list.insertTail(69);
		list.print();
		list.insertTail(43);
	}
}
