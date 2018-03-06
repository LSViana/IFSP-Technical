package br.edu.ifsp.spo.lg2.stack;

public interface StackInterface<T> {
    void push(T element);
    T pop();
    T top();
    int size();
    boolean isEmpty();
}
