package br.edu.ifsp.spo.lg2.list.doublylinked;

import br.edu.ifsp.spo.lg2.common.AdvancedNode;

public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T> {

    private AdvancedNode<T> head;
    private AdvancedNode<T> tail;
    private int size;

    public DoublyLinkedList() {
        // @Sentinel
//        head = new AdvancedNode<>();
//        tail = new AdvancedNode<>();
//        head.setNext(tail);
    }

    @Override
    public void addStart(T element) {
        AdvancedNode<T> node = new AdvancedNode<>();
        node.setValue(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
        // @Sentinel
//        addBetween(element, head, head.getNext());
    }

    @Override
    public void addEnd(T element) {
        AdvancedNode<T> node = new AdvancedNode<>();
        node.setValue(element);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.setPrevious(tail);
            tail = node;
        }
        size++;
        // @Sentinel
//        addBetween(element, tail.getPrevious(), tail);
    }

    @Override
    public void add(T element, int index) {
        verifyAvailableIndexes(index);
        AdvancedNode<T> node = new AdvancedNode<>();
        node.setValue(element);
        AdvancedNode<T> previousNode = null;
        if (index == size) {
            addEnd(element);
        } else if (index == 0) {
            addStart(element);
        } else {
            for (int i = 0; i < index; i++) {
                if(previousNode == null)
                    previousNode = head;
            }
            node.setNext(previousNode.getNext());
            previousNode.setNext(node);
        }
        size++;
    }

    @Override
    public T removeStart() {
        if(size == 0)
            return null;
        else {
            T element = head.getValue();
            if(head == tail) {
                head = null;
                tail = null;
            }
            else {
                head = head.getNext();
            }
            size--;
            return element;
        }
    }

    @Override
    public T removeEnd() {
        if(size == 0)
            return null;
        else {
            T element = tail.getValue();
            if(head == tail) {
                head = null;
                tail = null;
            }
            else {
                tail = tail.getPrevious();
            }
            size--;
            return element;
        }
    }

    @Override
    public T elementAt(int index) {
        verifyIndex(index);
        AdvancedNode<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
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
        AdvancedNode<T> node = head;
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

    private void addBetween(T element, AdvancedNode<T> previous, AdvancedNode<T> after) {
        AdvancedNode<T> node = new AdvancedNode<>();
        node.setValue(element);
        node.setPrevious(previous);
        node.setNext(after);
        size++;
    }

    private void verifyAvailableIndexes(int index) {
        if (index > size)
            throw new IndexOutOfBoundsException();
    }

    private void verifyIndex(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
    }
}
