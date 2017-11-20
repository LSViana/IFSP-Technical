package br.edu.ifsp.lg2.datastructures.queue;

public interface QueueInterface<T> {
    void enqueue(T element);
    T dequeue();
    T first();
    int size();
    boolean isEmpty();
}
