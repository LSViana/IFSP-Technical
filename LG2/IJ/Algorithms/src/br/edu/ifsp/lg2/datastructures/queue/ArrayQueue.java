package br.edu.ifsp.lg2.datastructures.queue;

public class ArrayQueue<T> implements QueueInterface<T> {

    public T[] elements;
    public int size;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int size) { elements = (T[]) new Object[size]; }

    @Override
    public void enqueue(T element) {
        ensureSize();
        elements[size++] = element;
    }

    private void ensureSize() {
        if (size == elements.length) {
            // Need to grow up
            T[] fresh = (T[]) new Object[size * 2];
            int i = 0;
            for (T element : elements) {
                fresh[i++] = element;
            }
            elements = fresh;
        }
    }

    @Override
    public T dequeue() {
        T result = elements[0];
        // Move all elements to the left
        int i;
        for(i = 1; i < elements.length; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--i] = null;
        return result;
    }

    @Override
    public T first() {
        return elements[0];
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
        for (T element : elements) {
            if(element == null)
                break;
            b.append(element).append(", ");
        }
        if (b.length() == 2)
            b.setLength(b.length() - 1);
        else
            b.setLength(b.length() - 2);
        b.append(" }");
        return b.toString();
    }
}
