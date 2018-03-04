package br.edu.ifsp.spo.lg2.vector;

public class Vector<T> implements VectorInterface<T> {

    private int size = 0;
    private T[] data;

    public Vector(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public Vector() {
        this(8);
    }

    @Override
    public void add(T element) {
        ensureSize();
        data[size++] = element;
    }

    @Override
    public void add(T element, int index) {
        ensureSize();
        verifyAvailableIndexes(index);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        verifyIndex(index);
        T element = data[index];
        for (index++; index < size; index++) {
            data[index - 1] = data[index];
        }
        data[index] = null;
        size--;
        return element;
    }

    @Override
    public boolean remove(T element) {
        int i = 0;
        for (; i < size; i++) {
            if(data[i].equals(element))
                break;
        }
        if(i == size)
            return false;
        else {
            remove(i);
            return true;
        }
    }

    @Override
    public T elementAt(int index) {
        verifyIndex(index);
        return data[index];
    }

    @Override
    public int size() {
        return size;
    }

    public String getTextData() {
        StringBuilder b = new StringBuilder("{ ");
        for (int i = 0; i < size; i++) {
            b.append(data[i]).append(", ");
        }
        if (b.length() != 2)
            b.setLength(b.length() - 2);
        b.append(" }");
        return b.toString();
    }

    protected void verifyAvailableIndexes(int index) {
        if(index > size)
            throw new IndexOutOfBoundsException();
    }

    protected void verifyIndex(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException();
    }

    protected void ensureSize() {
        if (size == data.length) {
            // Reallocate, it's full
            T[] fresh = (T[]) new Object[size * 2];
            for (int i = 0; i < size; i++) {
                fresh[i] = data[i];
            }
            data = fresh;
        }
    }
}
