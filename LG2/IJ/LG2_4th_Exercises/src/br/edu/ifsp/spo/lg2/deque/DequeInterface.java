package br.edu.ifsp.spo.lg2.deque;

public interface DequeInterface<T> {
    void addStart(T element);
    void addEnd(T element);
    T removeStart();
    T removeEnd();
    T first();
    T last();
    int size();
    boolean isEmpty();
}
