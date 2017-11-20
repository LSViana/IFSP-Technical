package br.edu.ifsp.lg2.datastructures;

import br.edu.ifsp.lg2.datastructures.queue.ArrayQueue;
import br.edu.ifsp.lg2.datastructures.vector.Vector;
import br.edu.ifsp.lg2.datastructures.vector.VectorObject;
import br.edu.ifsp.lg2.datastructures.vector.VectorString;

public class Main {

    public static void main(String[] args) {
        //vectorString();
        //vectorObject();
        //vectorGeneric();
        arrayQueue();
    }

    public static void arrayQueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(2);
        System.out.println(arrayQueue.getTextData());
        arrayQueue.enqueue("Lucas");
        arrayQueue.enqueue("Cecília");
        System.out.println(arrayQueue.getTextData());
        arrayQueue.enqueue("Roberto");
        System.out.println(arrayQueue.getTextData());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.getTextData());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.getTextData());
    }

    public static void vectorString() {
        VectorString stringVector = new VectorString();
        stringVector.printData();
        stringVector.add("Cecília");
        stringVector.printData();
        stringVector.add("Lucas");
        stringVector.add("Roberto", 0);
        stringVector.add("Latorre");
        stringVector.printData();
        stringVector.remove(2);
        stringVector.printData();
        stringVector.remove("Latorre");
        stringVector.printData();
    }

    public static void vectorObject() {
        VectorObject stringVector = new VectorObject();
        stringVector.printData();
        stringVector.add("Cecília");
        stringVector.printData();
        stringVector.add("Lucas");
        stringVector.add("Roberto", 0);
        stringVector.add("Latorre");
        stringVector.printData();
        stringVector.remove(2);
        stringVector.printData();
        stringVector.remove("Latorre");
        stringVector.printData();
    }

    public static void vectorGeneric() {
        Vector<String> stringVector = new Vector<>();
        stringVector.printData();
        stringVector.add("Cecília");
        stringVector.printData();
        stringVector.add("Lucas");
        stringVector.add("Roberto", 0);
        stringVector.add("Latorre");
        stringVector.printData();
        stringVector.remove(2);
        stringVector.printData();
        stringVector.remove("Latorre");
        stringVector.printData();
    }
}
