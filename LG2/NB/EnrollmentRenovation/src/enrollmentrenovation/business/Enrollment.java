package enrollmentrenovation.business;

public class Enrollment { 

    // Relationships
    private User Student;
    private SchoolClass SchoolClass;
    private Course Course;
    // Common fields
    private short Semester;
    private short Status;
    private float Grade;

    public Enrollment(User Student, SchoolClass SchoolClass, Course Course, short Semester, short Status, float Grade) {
        this.Student = Student;
        this.SchoolClass = SchoolClass;
        this.Course = Course;
        this.Semester = Semester;
        this.Status = Status;
        this.Grade = Grade;
    }

    public User getStudent() {
        return Student;
    }

    public void setStudent(User Student) {
        this.Student = Student;
    }

    public SchoolClass getSchoolClass() {
        return SchoolClass;
    }

    public void setSchoolClass(SchoolClass SchoolClass) {
        this.SchoolClass = SchoolClass;
    }

    public Course getCourse() {
        return Course;
    }

    public void setCourse(Course Course) {
        this.Course = Course;
    }

    public short getSemester() {
        return Semester;
    }

    public void setSemester(short Semester) {
        this.Semester = Semester;
    }

    public short getStatus() {
        return Status;
    }

    public void setStatus(short Status) {
        this.Status = Status;
    }

    public float getGrade() {
        return Grade;
    }

    public void setGrade(float Grade) {
        this.Grade = Grade;
    }
    
    

}