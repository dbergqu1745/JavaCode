package arrayStack;

public class ArrayStack {
	int[] Stack;
	int indTop, stackSize;
	
	public ArrayStack(int size) {
		Stack = new int[size];
		indTop = -1;
		stackSize = 0;
	}
	
	public void printStack() {
		System.out.println("bottom");
		
		for (int i = 0; i < stackSize; i++) {
			System.out.println(this.Stack[i]);
		}
		
		System.out.println("top");
		System.out.println();
	}
	
	public void push(int a) {
		if (checkForResize())
			this.reSize();
		
		this.Stack[++indTop] = a;
		
		++stackSize;
	}
	
	public int pop() {
		int n = this.Stack[indTop];
		--stackSize;
		return n;
	}
	
	public void peek() {
		System.out.println(this.Stack[indTop]);
	}
	
	public boolean checkForResize() {
		return (this.Stack.length == this.stackSize);
	}
	
	public void reSize() {
		int len = this.Stack.length;
		int[] newStack = new int[len * 2];
		
		for (int i = 0; i < len; i++) {
			newStack[i] = this.Stack[i];
		}
		
		this.Stack = newStack;
	}
	
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(3);
		
		arrayStack.push(3);
		arrayStack.printStack();
		
		arrayStack.push(1);
		arrayStack.printStack();
		
		arrayStack.push(17);
		arrayStack.printStack();
		
		arrayStack.push(6);
		arrayStack.printStack();
		
		System.out.println(arrayStack.pop());
		arrayStack.printStack();
		
		arrayStack.peek();
		
	}
}
