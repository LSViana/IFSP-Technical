package System.Business;
import java.time.LocalDate;
public class Credits implements EntityModel {
    private int IdStudent;
    private int IdDiscipline;
    private int IdCourse;
    private LocalDate DateRequirement;
    public Credits(int IdStudent, int IdDiscipline, int IdCourse, LocalDate DateRequirement) {
        this.IdStudent = IdStudent;
        this.IdDiscipline = IdDiscipline;
        this.IdCourse = IdCourse;
        this.DateRequirement = DateRequirement;
    }
    public int getIdStudent() {
        return IdStudent;
    }
    public void setIdStudent(int IdStudent) {
        this.IdStudent = IdStudent;
    }
    public int getIdDiscipline() {
        return IdDiscipline;
    }
    public void setIdDiscipline(int IdDiscipline) {
        this.IdDiscipline = IdDiscipline;
    }
    public int getIdCourse() {
        return IdCourse;
    }
    public void setIdCourse(int IdCourse) {
        this.IdCourse = IdCourse;
    }
    public LocalDate getDateRequirement() {
        return DateRequirement;
    }
    public void setDateRequirement(LocalDate DateRequirement) {
        this.DateRequirement = DateRequirement;
    }

    @Override
    public int[] getIds() {
        return new int[] { IdStudent, IdDiscipline, IdCourse };
    }
}