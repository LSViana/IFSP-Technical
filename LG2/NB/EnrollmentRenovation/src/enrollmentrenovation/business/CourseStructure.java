package enrollmentrenovation.business;
public class CourseStructure {
    private Course course;
    private Discipline discipline;
    private int Semester;
    private boolean Facultative;

    public CourseStructure(Course course, Discipline discipline, int Semester, boolean Facultative) {
        this.course = course;
        this.discipline = discipline;
        this.Semester = Semester;
        this.Facultative = Facultative;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
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

    
}
