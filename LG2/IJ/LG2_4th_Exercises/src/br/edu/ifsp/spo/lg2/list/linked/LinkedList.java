package br.edu.ifsp.spo.lg2.list.linked;

import br.edu.ifsp.spo.lg2.common.SimpleNode;

public class LinkedList<T> implements LinkedListInterface<T> {

    private SimpleNode<T> head;
    private SimpleNode<T> tail;
    private int size;

    @Override
    public void addStart(T element) {
        SimpleNode<T> node = new SimpleNode<>();
        node.setValue(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    @Override
    public void addEnd(T element) {
        SimpleNode<T> node = new SimpleNode<>();
        node.setValue(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
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
        SimpleNode<T> previousNode = head;
        if (index == size) {
            addEnd(element);
        } else if (index == 0) {
            addStart(element);
        } else {
            for (int i = 0; i < index - 1; i++) {
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
        SimpleNode<T> oldHead = head;
        head = head.getNext();
        size--;
        return oldHead.getValue();
    }

    @Override
    public T removeEnd() {
        if (size == 0)
            return null;
        SimpleNode<T> node = head;
        while (node.getNext() != null && !node.getNext().equals(tail))
            node = node.getNext();
        T element = null;
        if (head == tail) {
            element = head.getValue();
            head = null;
            tail = head;
        } else {
            element = node.getNext().getValue();
            node.setNext(null);
            tail = node;
        }
        size--;
        return element;
    }

    @Override
    public T first() {
        return head.getValue();
    }

    @Override
    public T last() {
        return tail.getValue();
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
        SimpleNode<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node == null)
                break;
            b.append(node.getValue()).append(", ");
            node = node.getNext();
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
