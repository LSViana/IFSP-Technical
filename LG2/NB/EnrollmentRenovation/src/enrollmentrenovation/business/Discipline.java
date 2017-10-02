package enrollmentrenovation.business;

import java.util.List;

public class Discipline {

    private int Id;
    private String Name;
    private List<SchoolClass> Classes;
    private List<CourseStructure> Courses;
    private List<Restriction> Requirements;

    public Discipline(int Id, String Name) {
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

    public List<SchoolClass> getClasses() {
        return Classes;
    }

    public void setClasses(List<SchoolClass> Classes) {
        this.Classes = Classes;
    }

    public List<CourseStructure> getCourses() {
        return Courses;
    }

    public void setCourses(List<CourseStructure> Courses) {
        this.Courses = Courses;
    }

    public List<Restriction> getRequirements() {
        return Requirements;
    }

    public void setRequirements(List<Restriction> Requirements) {
        this.Requirements = Requirements;
    }
    
    
}
