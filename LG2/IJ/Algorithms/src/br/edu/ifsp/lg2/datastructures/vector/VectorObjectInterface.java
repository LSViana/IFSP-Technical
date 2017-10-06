package br.edu.ifsp.lg2.datastructures.vector;

public interface VectorObjectInterface {
    public void add(Object item);
    public void add(Object item, int position);
    public void addRange(Object[] items);
    public Object remove(int position);
    public void remove(Object item);
    public Object elementAt(int position);
    public int indexOf(Object item);
    public int size();
}
