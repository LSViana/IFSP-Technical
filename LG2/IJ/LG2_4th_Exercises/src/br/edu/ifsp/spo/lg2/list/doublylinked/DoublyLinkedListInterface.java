package br.edu.ifsp.spo.lg2.list.doublylinked;

public interface DoublyLinkedListInterface<T> {
    void addStart(T element);
    void addEnd(T element);
    void add(T element, int index);
    T removeStart();
    T removeEnd();
    T elementAt(int index);
    int size();
    boolean isEmpty();
}
