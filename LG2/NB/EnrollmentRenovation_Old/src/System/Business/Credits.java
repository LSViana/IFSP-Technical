package System.Business;
import java.lang.reflect.Field;
import java.time.LocalDate;
public class Credits extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer IdStudent;
    private Integer IdDiscipline;
    private Integer IdCourse;
    private LocalDate DateRequirement;
    public Credits(Integer IdStudent, Integer IdDiscipline, Integer IdCourse, LocalDate DateRequirement) {
        this.IdStudent = IdStudent;
        this.IdDiscipline = IdDiscipline;
        this.IdCourse = IdCourse;
        this.DateRequirement = DateRequirement;
    }
    public Integer getIdStudent() {
        return IdStudent;
    }
    public void setIdStudent(Integer IdStudent) {
        this.IdStudent = IdStudent;
    }
    public Integer getIdDiscipline() {
        return IdDiscipline;
    }
    public void setIdDiscipline(Integer IdDiscipline) {
        this.IdDiscipline = IdDiscipline;
    }
    public Integer getIdCourse() {
        return IdCourse;
    }
    public void setIdCourse(Integer IdCourse) {
        this.IdCourse = IdCourse;
    }
    public LocalDate getDateRequirement() {
        return DateRequirement;
    }
    public void setDateRequirement(LocalDate DateRequirement) {
        this.DateRequirement = DateRequirement;
    }

    @Override
    public Integer[] getIds() {
        return new Integer[] { IdStudent, IdDiscipline, IdCourse };
    }
}