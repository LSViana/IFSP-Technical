package class3;

public class Dentist_Test {
    public static void main(String[] args) {
        Dentist d1 = new Dentist("Lucas Viana", 17);
        Dentist d2 = new Dentist("Roberto Bolgheroni", 16);
        Dentist d3 = new Dentist("Lucas Viana", 17);
        // Método equals()
        System.out.printf("d1.equals(d2): %s\n", d1.equals(d2));
        System.out.printf("d1.equals(d3): %s\n", d1.equals(d3));
        System.out.printf("d2.equals(d3): %s\n", d2.equals(d3));
        // Método hashCode()
        System.out.printf("d1.hashCode(): %s\n", d1.hashCode());
        System.out.printf("d2.hashCode(): %s\n", d2.hashCode());
        System.out.printf("d3.hashCode(): %s\n", d3.hashCode());
        // Método toString()
        System.out.printf("d1: %s\n", d1.toString());
        System.out.printf("d2: %s\n", d2.toString());
        System.out.printf("d3: %s\n", d3.toString());
    }
}
