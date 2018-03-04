package br.edu.ifsp.spo.lg2.vector;

public interface VectorInterface<T> {
    public void add(T element);
    public void add(T element, int index);
    public T remove(int index);
    public boolean remove(T element);
    public T elementAt(int index);
    public int size();
}
