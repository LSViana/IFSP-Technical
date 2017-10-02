package System.Business;
import java.lang.reflect.Field;
public class CourseStructure extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer IdCourse;
    private Integer IdDiscipline;
    private Integer Semester;
    private Boolean Facultative;
    public CourseStructure(Integer IdCourse, Integer IdDiscipline, Integer Semester, Boolean Facultative) {
        this.IdCourse = IdCourse;
        this.IdDiscipline = IdDiscipline;
        this.Semester = Semester;
        this.Facultative = Facultative;
    }
    public Integer getIdCourse() {
        return IdCourse;
    }
    public void setIdCourse(Integer IdCourse) {
        this.IdCourse = IdCourse;
    }
    public Integer getIdDiscipline() {
        return IdDiscipline;
    }
    public void setIdDiscipline(Integer IdDiscipline) {
        this.IdDiscipline = IdDiscipline;
    }
    public Integer getSemester() {
        return Semester;
    }
    public void setSemester(Integer Semester) {
        this.Semester = Semester;
    }
    public Boolean isFacultative() {
        return Facultative;
    }
    public void setFacultative(Boolean Facultative) {
        this.Facultative = Facultative;
    }
    @Override
    public Integer[] getIds() {
        return new Integer[] { IdCourse, IdDiscipline };
    }
}