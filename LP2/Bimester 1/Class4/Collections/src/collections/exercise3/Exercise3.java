package collections.exercise3;

import collections.exercise1.Professional;
import collections.exercise2.Engineer;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Method;
import java.util.Collection;

public class Exercise3 {

    public void test() {
        Engineer e1 = new Engineer(LocalDate.now(), 1, "Lucas Viana", 17),
                _e1 = new Engineer(LocalDate.now(), 1, "Lucas Viana", 17),
                e2 = new Engineer(LocalDate.now(), 2, "Victor Girardi", 16),
                e3 = new Engineer(LocalDate.now(), 3, "Roberto Bolgheroni", 19);
        Set<Professional> professionals = new HashSet<>();
        //
        professionals.add(e1);
        professionals.add(_e1);
        professionals.add(e2);
        professionals.add(e3);
        // Testing equals(Engineer)
        System.out.println("e1 equals _e1: " + (e1.equals(_e1)));
        // Testing hashCode
        printProfessionals(professionals, "hashCode");
        System.out.println();
        printProfessionals(professionals, "toString");
    }

    private void printProfessionals(Collection<Professional> professionals, String method) {
        Iterator<Professional> itrtr = professionals.iterator();
        try {
            Method methodObj = Professional.class.getMethod(method);
            while (itrtr.hasNext()) {
                Professional p = itrtr.next();
                System.out.printf("%s %s at method %s(): %s\n",
                        p.getClass().getSimpleName(),
                        p.getName(),
                        method,
                        methodObj.invoke(p)
                );
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Exercise3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
