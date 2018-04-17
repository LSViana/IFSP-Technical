package class3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Exercise6 {

    public static void main(String[] args) {
        // Coleção
        Collection<Dentist> dentists = new ArrayList<>();
        // Dentistas
        Dentist d1 = new Dentist("Lucas Viana", 17);
        Dentist d2 = new Dentist("Roberto Bolgheroni", 16);
        Dentist d3 = new Dentist("Glayson Olivieri", 18);
        dentists.add(d1);
        dentists.add(d2);
        dentists.add(d3);
        // Iterador
        Iterator<Dentist> iteratorDentists = dentists.iterator();
        // Método hasNext()
        while (iteratorDentists.hasNext()) {
            // Método next()
            Dentist d = iteratorDentists.next();
            // Remover se a idade for menor de 18 anos
            System.out.printf("Dentist: %s\n", d);
            if (d.getAge() < 18) {
                System.out.printf("\tRemoving dentist: %s\n", d);
                // Método remove()
                iteratorDentists.remove();
            }
        }
    }
}
