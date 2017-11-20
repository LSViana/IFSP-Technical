package br.edu.ifsp.lg2.datastructures.queue;

import br.edu.ifsp.lg2.datastructures.vector.Vector;

public class ListQueue<T> implements QueueInterface<T> {

    private Vector<T> vector;

    public ListQueue() {
        vector = new Vector<>();
    }

    @Override
    public void enqueue(T element) {
        vector.add(element);
    }

    @Override
    public T dequeue() {
        T element = vector.elementAt(0);
        vector.remove(0);
        return element;
    }

    @Override
    public T first() {
        return vector.elementAt(0);
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public boolean isEmpty() {
        return vector.size() == 0;
    }
}
