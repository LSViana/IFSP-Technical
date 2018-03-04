package br.edu.ifsp.spo.lg2.stack;

import br.edu.ifsp.spo.lg2.common.SimpleNode;

public class LinkedStack<T> implements StackInterface<T> {

    private int size;
    private SimpleNode<T> head;

    public LinkedStack() {
        // Standard constructor
    }

    @Override
    public void push(T element) {
        SimpleNode<T> freshHead = new SimpleNode<>();
        freshHead.setValue(element);
        freshHead.setNext(head);
        head = freshHead;
        size++;
    }

    @Override
    public T pop() {
        if(size == 0)
            return null;
        T element = head.getValue();
        head = head.getNext();
        size--;
        return element;
    }

    @Override
    public T top() {
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
