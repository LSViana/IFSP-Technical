package br.edu.ifsp.lg2.datastructures.vector;

public interface VectorStringInterface {
    public void add(String item);
    public void add(String item, int position);
    public void addRange(String[] items);
    public String remove(int position);
    public void remove(String item);
    public String elementAt(int position);
    public int indexOf(String item);
    public int size();
}