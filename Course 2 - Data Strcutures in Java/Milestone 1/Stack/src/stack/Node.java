package stack;

public class Node<T> {

	T data;
	
	Node<T> next; // will be null at first

	public Node(T data) {
    	this.data = data;
    	}
	
}
