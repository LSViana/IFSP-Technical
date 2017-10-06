package br.edu.ifsp.lg2.datastructures.vector;

public interface VectorInterface<X> {
    public void add(X item);
    public void add(X item, int position);
    public void addRange(X[] items);
    public X remove(int position);
    public void remove(X item);
    public X elementAt(int position);
    public int indexOf(X item);
    public int size();
}
