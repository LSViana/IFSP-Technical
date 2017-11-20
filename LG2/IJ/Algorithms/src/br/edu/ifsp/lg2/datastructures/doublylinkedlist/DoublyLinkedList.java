package br.edu.ifsp.lg2.datastructures.doublylinkedlist;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T> {

    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        // Standard constructor
    }

    @Override
    public void addStart(T item) {
        DoublyLinkedNode<T> node = new DoublyLinkedNode<>(item);
        node.setAfter(head);
        node.setPrevious(tail);
        head = node;
        size++;
    }

    @Override
    public void add(T item) {
        if (item == null)
            return;
        DoublyLinkedNode<T> node = new DoublyLinkedNode(item);
        tail.setAfter(node);
        tail = node;
        size++;
    }

    @Override
    public void add(T item, int position) throws InvalidArgumentException {
        if (item == null)
            return;
        DoublyLinkedNode<T> nodeAtPosition = head;
        for(int i = 0; i < position - 1; i++) {
            nodeAtPosition = nodeAtPosition.getAfter();
        }
        DoublyLinkedNode<T> node = new DoublyLinkedNode(item);
        node.setAfter(nodeAtPosition.getAfter());
        node.setPrevious(nodeAtPosition);

        nodeAtPosition.setAfter(node);
        size++;
    }

    private void verifyPosition(int position) throws InvalidArgumentException {
        if (position < 0 || position >= size)
            throw new InvalidArgumentException(new String[]{"position"});
    }

    @Override
    public T removeStart() {
        if (size == 0)
            return null;
        T element = elements[0];
        // Move all items to the left
        for (int i = size - 1; i > 0; i--) {
            elements[i - 1] = elements[i];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public T removeEnd() {
        if(size == 0)
            return null;
        T element = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public T first() {
        return elements[0];
    }

    @Override
    public T last() {
        return elements[t];
    }

    @Override
    public T elementAt(int position) {
        return null;
    }

    @Override
    public T remove(int position) {
        return null;
    }

    @Override
    public void remove(T item) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
