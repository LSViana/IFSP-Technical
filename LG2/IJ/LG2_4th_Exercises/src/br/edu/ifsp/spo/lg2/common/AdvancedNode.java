package br.edu.ifsp.spo.lg2.common;

public class AdvancedNode<T> extends Node<T> {
    protected AdvancedNode<T> next;
    protected AdvancedNode<T> previous;

    public AdvancedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(AdvancedNode<T> previous) {
        this.previous = previous;
        if(previous != null)
            previous.next = this;
    }

    public AdvancedNode<T> getNext() {
        return next;
    }

    public void setNext(AdvancedNode<T> next) {
        this.next = next;
        if(next != null)
            next.previous = this;
    }
}
