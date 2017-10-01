package enrollmentrenovation.business;

import java.util.List;

public class Course {

    private int Id;
    private String Name;
    private List<CourseStructure> Structure;
    private List<Enrollment> Enrollments;
    private School School;

    public Course(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
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

    public School getSchool() {
        return School;
    }

    public void setSchool(School School) {
        this.School = School;
    }
    
    
}
