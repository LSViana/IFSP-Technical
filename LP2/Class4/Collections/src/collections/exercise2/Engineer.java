package collections.exercise2;

import collections.exercise1.Professional;
import java.time.LocalDate;
import java.util.Objects;

public class Engineer extends Professional {
    
    private LocalDate initialDate;
    private Integer creaNumber;
    
    public Engineer() {
        super();
    }

    public Engineer(LocalDate initialDate, Integer creaNumber, String name, Integer age) {
        super(name, age);
        this.initialDate = initialDate;
        this.creaNumber = creaNumber;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public Integer getCreaNumber() {
        return creaNumber;
    }

    public void setCreaNumber(Integer creaNumber) {
        this.creaNumber = creaNumber;
    }

    @Override
    public int hashCode() {
        // Getting hashCode() from Professional
        int superHash = super.hashCode();
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.initialDate);
        hash = 67 * hash + Objects.hashCode(this.creaNumber);
        // Returning the hashCode() from super class together with this one
        return superHash * hash;
    }

    @Override
    public boolean equals(Object obj) {
        // Calling Professional implementation to ensure other attribute are also equal
        if(!super.equals(obj))
            return false;
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Engineer other = (Engineer) obj;
        if (!Objects.equals(this.initialDate, other.initialDate)) {
            return false;
        }
        if (!Objects.equals(this.creaNumber, other.creaNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // Returning also toString from the super class (Professional)
        return super.toString() + "|Engineer{" + "initialDate=" + initialDate + ", creaNumber=" + creaNumber + '}';
    }
    
}
