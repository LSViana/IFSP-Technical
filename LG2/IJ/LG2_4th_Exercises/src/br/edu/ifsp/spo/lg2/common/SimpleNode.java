package br.edu.ifsp.spo.lg2.common;

public class SimpleNode<T> extends Node<T> {
    protected SimpleNode<T> next;

    public SimpleNode<T> getNext() {
        return next;
    }

    public void setNext(SimpleNode<T> next) {
        this.next = next;
    }
}
