package br.edu.ifsp.spo.lg2.deque;

import br.edu.ifsp.spo.lg2.list.doublylinked.DoublyLinkedList;

public class Deque<T> implements DequeInterface<T> {

    private DoublyLinkedList<T> linkedList = new DoublyLinkedList<>();

    @Override
    public void addStart(T element) {
        linkedList.addStart(element);
    }

    @Override
    public void addEnd(T element) {
        linkedList.addEnd(element);
    }

    @Override
    public T removeStart() {
        return linkedList.removeStart();
    }

    @Override
    public T removeEnd() {
        return linkedList.removeEnd();
    }

    @Override
    public T first() {
        return linkedList.elementAt(0);
    }

    @Override
    public T last() {
        return linkedList.elementAt(linkedList.size() - 1);
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public String getTextData() {
        return linkedList.getTextData();
    }
}