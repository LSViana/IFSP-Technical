package br.edu.ifsp.spo.lg2.list.circular;

public interface CircularListInterface<T> {
    void addStart(T element);
    void addEnd(T element);
    void add(T element, int index);
    T removeStart();
    T removeEnd();
    T first();
    T last();
    T elementAt(int index);
    int size();
    boolean isEmpty();
}
