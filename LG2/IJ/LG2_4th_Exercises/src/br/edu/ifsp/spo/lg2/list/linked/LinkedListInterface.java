package br.edu.ifsp.spo.lg2.list.linked;

public interface LinkedListInterface<T> {
    void addStart(T element);
    void addEnd(T element);
    void add(T element, int index);
    T removeStart();
    T removeEnd();
    T first();
    T last();
    int size();
    boolean isEmpty();
}
