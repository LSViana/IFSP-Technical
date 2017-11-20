package br.edu.ifsp.lg2.datastructures.doublylinkedlist;

import com.sun.javaws.exceptions.InvalidArgumentException;

public interface DoublyLinkedListInterface<T> {
    void addStart(T item);
    void add(T item);
    void add(T item, int position) throws InvalidArgumentException;
    T removeStart();
    T removeEnd();
    T first();
    T last();
    T elementAt(int position) throws InvalidArgumentException;
    T remove(int position) throws InvalidArgumentException;
    void remove(T item);
    int size();
    boolean isEmpty();
}
