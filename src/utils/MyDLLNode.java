package utils;

public class MyDLLNode<E> {

	protected E element;
	protected MyDLLNode<E> next, prev;

	public MyDLLNode(E element) {
		this.element = element;
	}

	public MyDLLNode(E elem, MyDLLNode<E> prev, MyDLLNode<E> next) {
		this.element = elem;
		this.prev = prev;
		this.next = next;
	}

}