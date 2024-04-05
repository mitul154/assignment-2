package utils;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import interfaces.*;
import interfaces.ListADT;

public class MyArrayList<E> implements ListADT<E> {


	private static final long serialVersionUID = -6641976547739553233L;
	private final int CAPACITY = 10;
	private E[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (E[]) new Object[CAPACITY];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array = (E[]) new Object[CAPACITY];
		size = 0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		checkCapacity();
		for(int i = size; i > index; i--) {
			array[i] = array[i-1];
		}
		array[index] = toAdd;
		size++;
		return true;
	}

	private void checkCapacity() {
		if (size == array.length) {
			@SuppressWarnings("unchecked")
			E[] newArray = (E[])new Object[size * 2];
			for(int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null) throw new NullPointerException();
		checkCapacity();
		array[this.size] = toAdd;
		this.size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		
		if (toAdd == null) {
			throw new NullPointerException();
		}
		for(int i = 0; i <toAdd.size(); i++ ) {
			add(toAdd.get(i));
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index <0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E r = array[index];
		for(int i = index; i < size; i++) {
			array[i] = array[i+1];
		}
		size--;
		return r;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		if(toRemove == null) {
			throw new NullPointerException();
		}
				
		for(int i =0; i < size;i++ ) {
			E store = array[i];
			if(array[i] == toRemove) {
				for(int j = i; j < size; j++ ) {
					array[j] = array[j+1];
				}
				size--;
				return store;
			}
		}
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if( toChange == null) {
			throw new NullPointerException();
		}
		E retrunItem = array[index];
		array[index] = toChange;
		return retrunItem;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0)return true;
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		if(toFind == null) {
			throw new NullPointerException();
		}
		for(int i = 0; i < size; i++) {
			if (array[i] == toFind) {
				return true;
			}
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		if (toHold == null) {
			throw new NullPointerException();
		}

		if (toHold.length < this.size) {
			toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
		}

		for (int i = 0; i < this.size(); i++) {
			toHold[i] = this.get(i);
		}

		return toHold;

	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		E[] result = (E[]) new Object[this.size];
		for (int i = 0; i < this.size; i++) {
			result[i] = array[i];
		}
		return result;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayBasedIterator();
	}
	private class ArrayBasedIterator implements Iterator<E>{
	 
		private E[] copyOfElements;
		private int pos;
		
	    @SuppressWarnings("unchecked")
	    public ArrayBasedIterator() {
	        copyOfElements = (E[]) new Object[size];
	        System.arraycopy(array, 0, copyOfElements, 0, copyOfElements.length);
	    }
	    
	    @Override
	    public boolean hasNext() {
	        return pos < copyOfElements.length;
	    }
	    
	    @Override
	    public E next() {
	    	if(pos == copyOfElements.length) {
	    		throw new NoSuchElementException();
	    	}
	    	return copyOfElements[pos++];
	    }
	 	

}}
