package br.edu.ifsp.spo.lg2.queue;

public interface QueueInterface<T> {
    void enqueue(T element);
    T dequeue();
    T first();
    int size();
    boolean isEmpty();
}
