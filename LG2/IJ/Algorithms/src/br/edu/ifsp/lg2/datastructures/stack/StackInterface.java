package br.edu.ifsp.lg2.datastructures.stack;

public interface StackInterface<T> {
    T pop();
    T top();
    void push(T element);
    int size();
    boolean isEmpty();
}
