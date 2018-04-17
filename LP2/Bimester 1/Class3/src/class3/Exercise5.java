package class3;

import java.util.ArrayList;
import java.util.Collection;

public class Exercise5 {
    public static void main(String[] args) {
        // Coleção
        Collection<Dentist> dentists = new ArrayList<>();
        // Dentistas
        Dentist d1 = new Dentist("Lucas Viana", 17);
        Dentist d2 = new Dentist("Roberto Bolgheroni", 16);
        // Método add(T)
        System.out.printf("Size of 'dentists': %s\n", dentists.size());
        dentists.add(d1);
        System.out.printf("Size of 'dentists': %s\n", dentists.size());
        dentists.add(d2);
        // Método remove(T)
        System.out.printf("Size of 'dentists': %s\n", dentists.size());
        dentists.remove(d2);
        System.out.printf("Size of 'dentists': %s\n", dentists.size());
        // Método contains(T)
        System.out.printf("'dentists' contains d1: %s\n", dentists.contains(d1));
        System.out.printf("'dentists' contains d2: %s\n", dentists.contains(d2));
    }
}
