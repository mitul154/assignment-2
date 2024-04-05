package utils;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import interfaces.Iterator;
import interfaces.ListADT;

public class MyDLL<E> implements ListADT<E> {

	private static final long serialVersionUID = -7140796753013938413L;

	private int size;

	private MyDLLNode<E> head, tail;

	public MyDLL() {
		this.head = this.tail = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		if (toAdd == null) {
			throw new NullPointerException();
		}
		MyDLLNode<E> newElement = new MyDLLNode<E>(toAdd);
		if (size == 0) {
			head = newElement;
			tail = newElement;
		} else {
			if (index == 0) {
				newElement.next = head;
				head.prev = newElement;
				head = newElement;
			} else if (index == this.size) {
				tail.next = newElement;
				newElement.prev = tail;
				tail = newElement;
			} else {
				MyDLLNode<E> currNode = head;
				for (int i = 0; i < index; i++) {
					currNode = currNode.next;
				}
				newElement.next = currNode.next;
				currNode.next.prev = newElement;
				currNode.next = newElement;
				newElement.prev = currNode;
			}

		}
		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (toAdd == null) {
			throw new NullPointerException();
		}
		add(size, toAdd);
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		if (toAdd == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < toAdd.size(); i++) {
			this.add(toAdd.get(i));
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> indexElement = head;
		for (int i = 0; i < index; i++) {
			indexElement = indexElement.next;
		}
		return (E) indexElement.element;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			if (index == 0) {
				head = currentNode.next;
				head.prev = null;
			} else if (index == size - 1) {
				tail = currentNode.prev;
				tail.next = null;
			} else {
				currentNode.prev.next = currentNode.next;
				currentNode.next.prev = currentNode.prev;
			}
		}
		size--;
		return (E) currentNode.element;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		if (toRemove == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < size; i++) {
			if (this.get(i).equals(toRemove)) {
				remove(i);
				return toRemove;
			}
		}
		size--;
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if (toChange == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		E element = (E) temp.element;
		temp.element = toChange;

		return (E) element;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		if (toFind == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < size; i++) {
			if (this.get(i) == toFind) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		if (toHold == null) {
			throw new NullPointerException();
		}

		if (toHold.length < this.size) {
			toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
		}
		for (int i = 0; i < size; i++) {
			toHold[i] = this.get(i);
		}
		return toHold;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		E[] result = (E[]) new Object[this.size];
		for (int i = 0; i < this.size; i++) {
			result[i] = this.get(i);
		}
		return result;
	}
	MyDLL<E> myDLL = this;
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		Iterator<E> it = new Iterator<E>() {
			int initialSize = 0;

			@Override

			public boolean hasNext() {
				return initialSize < size && myDLL.get(initialSize) != null;
			}

			@Override
			public E next() {
				if (!this.hasNext()) {
					throw new NoSuchElementException();
				}
				return myDLL.get(initialSize++);
			}
		};
		return it;
	}

}
