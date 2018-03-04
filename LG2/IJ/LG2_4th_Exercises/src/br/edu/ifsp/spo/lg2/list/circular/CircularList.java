package br.edu.ifsp.spo.lg2.list.circular;

import br.edu.ifsp.spo.lg2.common.SimpleNode;

public class CircularList<T> implements CircularListInterface<T> {

    private SimpleNode<T> tail;
    private int size = 0;

    @Override
    public void addStart(T element) {
        SimpleNode<T> node = new SimpleNode<>();
        node.setValue(element);
        if (size == 0) {
            tail = node;
        } else {
            if (size == 1)
                node.setNext(tail);
            else
                node.setNext(tail.getNext());
            tail.setNext(node);
        }
        size++;
    }

    @Override
    public void addEnd(T element) {
        SimpleNode<T> node = new SimpleNode<>();
        node.setValue(element);
        if (size == 0) {
            tail = node;
        } else {
            node.setNext(tail.getNext());
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        verifyAvailableIndexes(index);
        SimpleNode<T> node = new SimpleNode<>();
        node.setValue(element);
        SimpleNode<T> previousNode = tail;
        if (index == size) {
            addEnd(element);
        } else if (index == 0) {
            addStart(element);
        } else {
            for (int i = 0; i < index; i++) {
                previousNode = previousNode.getNext();
            }
            node.setNext(previousNode.getNext());
            previousNode.setNext(node);
        }
        size++;
    }

    @Override
    public T removeStart() {
        if (size == 0)
            return null;
        T element = null;
        if (size == 1) {
            element = tail.getValue();
            tail = null;
        } else {
            element = tail.getNext().getValue();
            tail.setNext(tail.getNext().getNext());
        }
        size--;
        return element;
    }

    @Override
    public T removeEnd() {
        if (size == 0)
            return null;
        T element = null;
        if (size == 1) {
            return removeStart();
        } else {
            SimpleNode<T> node = tail.getNext();
            while (node != null && !node.getNext().equals(tail))
                node = node.getNext();
            node.setNext(tail.getNext());
            element = tail.getValue();
            tail = node;
        }
        size--;
        return element;
    }

    @Override
    public T first() {
        if (size == 0)
            return null;
        else if (size == 1)
            return tail.getValue();
        else
            return tail.getNext().getValue();
    }

    @Override
    public T last() {
        if (size == 0)
            return null;
        else
            return tail.getValue();
    }

    @Override
    public T elementAt(int index) {
        return null;
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
        if (size != 0) {
            SimpleNode<T> node = tail;
            node = tail.getNext();
            do {
                if (node == null)
                    break;
                b.append(node.getValue()).append(", ");
                node = node.getNext();
            }
            while (node != null && !node.equals(tail));
            b.append(tail.getValue()).append(", ");
        }
        if (b.length() != 2)
            b.setLength(b.length() - 2);
        b.append(" }");
        return b.toString();
    }

    private void verifyAvailableIndexes(int index) {
        if (index > size)
            throw new IndexOutOfBoundsException();
    }
}
