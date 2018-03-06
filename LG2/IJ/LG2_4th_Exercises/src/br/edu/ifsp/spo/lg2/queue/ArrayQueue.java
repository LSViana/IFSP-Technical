package br.edu.ifsp.spo.lg2.queue;

import br.edu.ifsp.spo.lg2.common.SimpleNode;

public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] data;
    private int size;

    public ArrayQueue(int capacity) {
        data = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T element) {
        if (size == data.length)
            throw new RuntimeException("Queue is full");
        data[size] = element;
        size++;
    }

    @Override
    public T dequeue() {
        if(size == 0)
            return null;
        T element;
        size--;
        element = data[0];
        data[0] = null;
        for (int i = 0; i < size; i++) {
            data[i] = data[i + 1];
        }
        return element;
    }

    @Override
    public T first() {
        if(size == 0)
            return null;
        return data[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String getTextData() {
        StringBuilder b = new StringBuilder("{ ");
        for (int i = 0; i < size; i++) {
            b.append(data[i]).append(", ");
        }
        if(b.length() != 2)
            b.setLength(b.length() - 2);
        b.append(" }");
        return b.toString();
    }
}
