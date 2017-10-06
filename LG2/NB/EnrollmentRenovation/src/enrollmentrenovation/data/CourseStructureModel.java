package enrollmentrenovation.data;
import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.Discipline;
public interface CourseStructureModel extends EntityModel<CourseStructure> {
    public CourseStructure get(Course course, Discipline discipline) throws Exception;
    public CourseStructure get(int IdCourse, int IdDiscipline) throws Exception;
    // Relationships
    public Course getCourse(CourseStructure courseStructure) throws Exception;
    public Discipline getDiscipline(CourseStructure courseStructure) throws Exception;
}
