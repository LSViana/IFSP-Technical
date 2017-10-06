package enrollmentrenovation.business;

import java.util.List;

public class School {
    private int Id;
    private String Name;
    private State State;
    // Relationships
    private List<Course> Courses;

    public School(int Id, String Name, State State, List<Course> Courses) {
        this.Id = Id;
        this.Name = Name;
        this.State = State;
        this.Courses = Courses;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public State getState() {
        return State;
    }

    public void setState(State State) {
        this.State = State;
    }

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> Courses) {
        this.Courses = Courses;
    }
    
    
    
}