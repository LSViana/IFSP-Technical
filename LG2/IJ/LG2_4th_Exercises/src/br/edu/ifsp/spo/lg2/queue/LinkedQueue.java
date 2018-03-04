package br.edu.ifsp.spo.lg2.queue;

import br.edu.ifsp.spo.lg2.common.SimpleNode;

public class LinkedQueue<T> implements QueueInterface<T> {

    private SimpleNode<T> head;
    private SimpleNode<T> tail;
    private int size;

    @Override
    public void enqueue(T element) {
        SimpleNode<T> freshTail = new SimpleNode<>();
        freshTail.setValue(element);
        if(size == 0) {
            head = freshTail;
            tail = freshTail;
        }
        else {
            tail.setNext(freshTail);
            tail = freshTail;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if(size == 0)
            return null;
        T element = head.getValue();
        head = head.getNext();
        size--;
        return element;
    }

    @Override
    public T first() {
        if(size == 0)
            return null;
        return head.getValue();
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
            if(node == null)
                break;
            b.append(node.getValue()).append(", ");
            node = node.getNext();
        }
        if(b.length() != 2)
            b.setLength(b.length() - 2);
        b.append(" }");
        return b.toString();
    }
}
