package enrollmentrenovation.business;

import java.util.List;

public class Course {

    private int Id;
    private String Name;
    // Relationships
    private School School;
    private List<Credits> Credits;
    private List<CourseStructure> Structure;
    private List<Enrollment> Enrollments;

    public Course(int Id, String Name, School School, List<Credits> Credits, List<CourseStructure> Structure, List<Enrollment> Enrollments) {
        this.Id = Id;
        this.Name = Name;
        this.School = School;
        this.Credits = Credits;
        this.Structure = Structure;
        this.Enrollments = Enrollments;
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

    public School getSchool() {
        return School;
    }

    public void setSchool(School School) {
        this.School = School;
    }

    public List<Credits> getCredits() {
        return Credits;
    }

    public void setCredits(List<Credits> Credits) {
        this.Credits = Credits;
    }

    public List<CourseStructure> getStructure() {
        return Structure;
    }

    public void setStructure(List<CourseStructure> Structure) {
        this.Structure = Structure;
    }

    public List<Enrollment> getEnrollments() {
        return Enrollments;
    }

    public void setEnrollments(List<Enrollment> Enrollments) {
        this.Enrollments = Enrollments;
    }
}
