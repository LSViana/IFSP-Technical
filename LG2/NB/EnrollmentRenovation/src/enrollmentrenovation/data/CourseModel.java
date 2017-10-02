package enrollmentrenovation.data;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.School;
import java.util.List;
public interface CourseModel extends EntityModel<Course> {
    public List<CourseStructure> getStructures(Course course);
    public void insertStructure(CourseStructure courseStructure);
    public CourseStructure containsDiscipline(Course course, Discipline discipline);
    public List<Enrollment> getEnrollments(Course course);
    public School getSchool(Course course);
    public Course get(int Id);
    public Course get(String Name);
}
