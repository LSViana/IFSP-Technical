package br.edu.ifsp.lg2.datastructures.stack;

import br.edu.ifsp.lg2.datastructures.vector.Vector;

public class ListStack<T> implements StackInterface<T> {

    private Vector<T> vector;

    public ListStack() {
        vector = new Vector<>();
    }

    @Override
    public T pop() {
        T element = vector.elementAt(0);
        vector.remove(0);
        return element;
    }

    @Override
    public T top() {
        return vector.elementAt(0);
    }

    @Override
    public void push(T element) {
        vector.add(element, 0);
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
