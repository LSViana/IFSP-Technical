package enrollmentrenovation.business;

import java.time.LocalDate;

public class Credits {

    private LocalDate DateRequirement;
    // Relationships
    private User Student;
    private Discipline Discipline;
    private Course Course;    

    public Credits(LocalDate DateRequirement, User Student, Discipline Discipline, Course Course) {
        this.DateRequirement = DateRequirement;
        this.Student = Student;
        this.Discipline = Discipline;
        this.Course = Course;
    }

    public LocalDate getDateRequirement() {
        return DateRequirement;
    }

    public void setDateRequirement(LocalDate DateRequirement) {
        this.DateRequirement = DateRequirement;
    }

    public User getStudent() {
        return Student;
    }

    public void setStudent(User Student) {
        this.Student = Student;
    }

    public Discipline getDiscipline() {
        return Discipline;
    }

    public void setDiscipline(Discipline Discipline) {
        this.Discipline = Discipline;
    }

    public Course getCourse() {
        return Course;
    }

    public void setCourse(Course Course) {
        this.Course = Course;
    }
    
    
    
}
