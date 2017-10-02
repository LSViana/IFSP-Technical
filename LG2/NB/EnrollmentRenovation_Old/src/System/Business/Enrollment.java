package System.Business;
import java.lang.reflect.Field;
public class Enrollment extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer IdStudent;
    private Integer IdClass;
    private Integer IdCourse;
    private Integer Semester;
    private Integer Status;
    private Double Grade;
    public Enrollment(Integer IdStudent, Integer IdClass, Integer IdCourse, Integer Semester, Integer Status, Double Grade) {
        this.IdStudent = IdStudent;
        this.IdClass = IdClass;
        this.IdCourse = IdCourse;
        this.Semester = Semester;
        this.Status = Status;
        this.Grade = Grade;
    }
    public Integer getIdStudent() {
        return IdStudent;
    }
    public void setIdStudent(Integer IdStudent) {
        this.IdStudent = IdStudent;
    }
    public Integer getIdClass() {
        return IdClass;
    }
    public void setIdClass(Integer IdClass) {
        this.IdClass = IdClass;
    }
    public Integer getIdCourse() {
        return IdCourse;
    }
    public void setIdCourse(Integer IdCourse) {
        this.IdCourse = IdCourse;
    }
    public Integer getSemester() {
        return Semester;
    }
    public void setSemester(Integer Semester) {
        this.Semester = Semester;
    }
    public Integer getStatus() {
        return Status;
    }
    public void setStatus(Integer Status) {
        this.Status = Status;
    }
    public Double getGrade() {
        return Grade;
    }
    public void setGrade(Double Grade) {
        this.Grade = Grade;
    }    

    @Override
    public Integer[] getIds() {
        return new Integer[] { IdStudent, IdClass, IdCourse };
    }
}