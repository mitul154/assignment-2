package utils;

import exceptions.EmptyQueueException;
import interfaces.*;

public class MyQueue<E> implements QueueADT<E> {

    /**
     * 
     */
    private static final long serialVersionUID = 9044049313499921350L;

    private MyDLL<E> queue;

    public MyQueue() {
        queue = new MyDLL<E>();
    }

    @Override
    public void enqueue(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        queue.add(element);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (queue.isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue.remove(0);
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (queue.isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue.get(0);
    }

    @Override
    public void dequeueAll() {
        queue.clear();
    }

    @Override
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> otherQueue) {
        if (this.size() != otherQueue.size()) {
            return false;
        }
        Iterator<E> thisIterator = this.iterator();
        Iterator<E> otherIterator = otherQueue.iterator();
        while (thisIterator.hasNext()) {
            if (!thisIterator.next().equals(otherIterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public E[] toArray(E[] array) throws NullPointerException {
        if (array == null) {
            throw new NullPointerException();
        }
        return queue.toArray(array);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return queue.size();
    }
}