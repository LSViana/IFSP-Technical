package br.edu.ifsp.lg2.datastructures.vector;

public class VectorString implements VectorStringInterface {
    private String[] data;
    private int size;
    public VectorString() { this(16); }
    public VectorString(int initialCapacity) {
        size = 0;
        data = new String[initialCapacity];
    }
    // Interface methods
    @Override
    public void add(String item) {
        ensureCapacity();
        data[size] = item;
        size++;
    }

    @Override
    public void add(String item, int position) {
        if(position > size + 1)
            verifyPosition(position);
        ensureCapacity();
        // Move all items to the right, if it is necessary, starting at the last position until the desired position
        for (int i = size - 1; i >= position; i--) {
            data[i + 1] = data[i];
        }
        data[position] = item;
        size++;
    }

    @Override
    public void addRange(String[] items) {
        for(String item : items)
            add(item);
    }

    @Override
    public String remove(int position) {
        verifyPosition(position);
        // Move all items to the left, starting at the position until the last one
        String removed = data[position];
        for (int i = position; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }

    @Override
    public void remove(String item) {
        int position = indexOf(item);
        if(position != -1) {
                remove(position);
                return;
        }
        throw new RuntimeException("Item supplied doesn't exist at the current list");
    }

    @Override
    public String elementAt(int position) {
        verifyPosition(position);
        return data[position];
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if(item.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
    // Additional methods
    public void printData() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if(i != 0)
                System.out.print(", ");
            System.out.printf("%d:%s", i, data[i]);
        }
        System.out.println("]");
    }

    // Private methods to optimize the class working
    private void verifyPosition(int position) {
        if(position >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("Invalid position to access: %d", position));
        }
    }
    private void ensureCapacity() {
        if(size == data.length) {
            String[] fresh = new String[data.length * 2];
            copyArray(data, fresh);
            data = fresh;
        }
    }
    private void copyArray(String[] old, String[] fresh) {
        for (int i = 0; i < size; i++) {
            fresh[i] = old[i];
        }
    }
}
