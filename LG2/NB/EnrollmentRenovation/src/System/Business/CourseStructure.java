package System.Business;
public class CourseStructure implements EntityModel {
    private int IdCourse;
    private int IdDiscipline;
    private int Semester;
    private boolean Facultative;
    public CourseStructure(int IdCourse, int IdDiscipline, int Semester, boolean Facultative) {
        this.IdCourse = IdCourse;
        this.IdDiscipline = IdDiscipline;
        this.Semester = Semester;
        this.Facultative = Facultative;
    }
    public int getIdCourse() {
        return IdCourse;
    }
    public void setIdCourse(int IdCourse) {
        this.IdCourse = IdCourse;
    }
    public int getIdDiscipline() {
        return IdDiscipline;
    }
    public void setIdDiscipline(int IdDiscipline) {
        this.IdDiscipline = IdDiscipline;
    }
    public int getSemester() {
        return Semester;
    }
    public void setSemester(int Semester) {
        this.Semester = Semester;
    }
    public boolean isFacultative() {
        return Facultative;
    }
    public void setFacultative(boolean Facultative) {
        this.Facultative = Facultative;
    }
    @Override
    public int[] getIds() {
        return new int[] { IdCourse, IdDiscipline };
    }
}