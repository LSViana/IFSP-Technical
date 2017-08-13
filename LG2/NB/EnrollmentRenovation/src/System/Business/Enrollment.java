package System.Business;
public class Enrollment implements EntityModel {
    private int IdStudent;
    private int IdClass;
    private int IdCourse;
    private int Semester;
    private int Status;
    private double Grade;
    public Enrollment(int IdStudent, int IdClass, int IdCourse, int Semester, int Status, double Grade) {
        this.IdStudent = IdStudent;
        this.IdClass = IdClass;
        this.IdCourse = IdCourse;
        this.Semester = Semester;
        this.Status = Status;
        this.Grade = Grade;
    }
    public int getIdStudent() {
        return IdStudent;
    }
    public void setIdStudent(int IdStudent) {
        this.IdStudent = IdStudent;
    }
    public int getIdClass() {
        return IdClass;
    }
    public void setIdClass(int IdClass) {
        this.IdClass = IdClass;
    }
    public int getIdCourse() {
        return IdCourse;
    }
    public void setIdCourse(int IdCourse) {
        this.IdCourse = IdCourse;
    }
    public int getSemester() {
        return Semester;
    }
    public void setSemester(int Semester) {
        this.Semester = Semester;
    }
    public int getStatus() {
        return Status;
    }
    public void setStatus(int Status) {
        this.Status = Status;
    }
    public double getGrade() {
        return Grade;
    }
    public void setGrade(double Grade) {
        this.Grade = Grade;
    }    

    @Override
    public int[] getIds() {
        return new int[] { IdStudent, IdClass, IdCourse };
    }
}