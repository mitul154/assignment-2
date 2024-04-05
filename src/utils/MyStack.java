package utils;

import java.util.EmptyStackException;
import interfaces.*;

/**
 * The MyStack class represents a stack data structure implemented using a MyArrayList.
 * It provides methods for pushing elements onto the stack, popping elements from the stack,
 * peeking at the top element, clearing the stack, checking if the stack is empty,
 * converting the stack to an array, searching for elements, and iterating over the stack.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStack<E> implements StackADT<E> {

    private static final long serialVersionUID = -5020374182030896278L;
    
    /**
     * The underlying MyArrayList used to store the stack elements.
     */
    MyArrayList<E> stack;

    /**
     * Constructs an empty stack.
     */
    public MyStack() {
        stack = new MyArrayList<E>();
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param toAdd the element to be pushed onto the stack
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException();
        }
        stack.add(toAdd);
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() throws EmptyStackException {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E peek() throws EmptyStackException {
        if (stack.isEmpty())
            throw new EmptyStackException();
        return stack.get(stack.size() - 1);
    }

    /**
     * Removes all elements from the stack.
     */
    @Override
    public void clear() {
        stack.clear();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (stack.size() == 0) return true;
        return false;
    }

    /**
     * Returns an array containing all the elements in the stack.
     *
     * @return an array containing all the elements in the stack
     */
    @Override
    public Object[] toArray() {
        Object[] quandaleDingle = stack.toArray();
        return quandaleDingle;
    }

    /**
     * Returns an array containing all the elements in the stack.
     *
     * @param holder the array into which the elements of the stack are to be stored
     * @return an array containing all the elements in the stack
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        if (holder == null) {
        }
        return stack.toArray(holder);
    }

    /**
     * Checks if the stack contains the specified element.
     *
     * @param toFind the element to search for
     * @return true if the stack contains the specified element, false otherwise
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return stack.contains(toFind);
    }

    /**
     * Searches for the specified element in the stack and returns its distance from the top.
     *
     * @param toFind the element to search for
     * @return the distance of the element from the top of the stack, or -1 if the element is not found
     */
    @Override
    public int search(E toFind) {
        int search = 1;
        for (int i = stack.size() - 1; i >= 0; i--) {
            E next = stack.get(i);
            if (next.equals(toFind)) {
                return search;
            }
            search++;
        }
        return -1;
    }

    /**
     * Returns an iterator over the elements in the stack in proper sequence.
     *
     * @return an iterator over the elements in the stack in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        MyArrayList<E> stackArrayList = new MyArrayList<E>();
        stackArrayList.addAll(stack);
        int stackSize = stack.size();
        int lastIndex = stackSize - 1;
        for (int i = 0; i < stackSize; i++) {
            E next = stack.get(i);
            stackArrayList.set(lastIndex, next);
            lastIndex--;
        }
        Iterator<E> stackIterator = stackArrayList.iterator();
        return stackIterator;
    }

    /**
     * Compares this stack to another stack for equality.
     *
     * @param that the stack to compare against
     * @return true if the stacks are equal, false otherwise
     */
    @Override
    public boolean equals(StackADT<E> that) {
        return false;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return stack.size();
    }
}