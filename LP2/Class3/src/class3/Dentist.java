package class3;

import java.util.Objects;

public class Dentist implements Comparable<Dentist> {
    private String name;
    private Integer age;

    public Dentist(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + Objects.hashCode(this.age);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dentist other = (Dentist) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dentist{" + "name=" + name + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Dentist t) {
        // Comparando por nome
        return getName().compareTo(t.getName());
    }
}
