package br.edu.ifsp.lg2.datastructures;

import br.edu.ifsp.lg2.datastructures.vector.Vector;
import br.edu.ifsp.lg2.datastructures.vector.VectorObject;
import br.edu.ifsp.lg2.datastructures.vector.VectorString;

public class Main {

    public static void main(String[] args) {
        //vectorString();
        //vectorObject();
        vectorGeneric();
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
