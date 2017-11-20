package br.edu.ifsp.lg2.datastructures.doublylinkedlist;

public class DoublyLinkedNode<T> {
    private T element;
    private DoublyLinkedNode<T> previous;
    private DoublyLinkedNode<T> after;
    //
    public DoublyLinkedNode(T element) {
        this.element = element;
    }
    //

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    public DoublyLinkedNode<T> getAfter() {
        return after;
    }

    public void setAfter(DoublyLinkedNode<T> after) {
        this.after = after;
    }
}
