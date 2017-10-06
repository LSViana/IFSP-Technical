package enrollmentrenovation.business;

import java.time.LocalDate;
import java.util.List;

public class User {

    private int Id;
    private String FirstName;
    private String LastName;
    private LocalDate Birthday;
    private String Password;
    private int Type;
    // Relationships
    private State State;
    private List<Credits> Credits;
    private List<Enrollment> Enrollments;

    public User(int Id, String FirstName, String LastName, LocalDate Birthday, String Password, int Type, State State, List<Credits> Credits, List<Enrollment> Enrollments) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Birthday = Birthday;
        this.Password = Password;
        this.Type = Type;
        this.State = State;
        this.Credits = Credits;
        this.Enrollments = Enrollments;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate Birthday) {
        this.Birthday = Birthday;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public State getState() {
        return State;
    }

    public void setState(State State) {
        this.State = State;
    }

    public List<Credits> getCredits() {
        return Credits;
    }

    public void setCredits(List<Credits> Credits) {
        this.Credits = Credits;
    }

    public List<Enrollment> getEnrollments() {
        return Enrollments;
    }

    public void setEnrollments(List<Enrollment> Enrollments) {
        this.Enrollments = Enrollments;
    }

    
    
}
