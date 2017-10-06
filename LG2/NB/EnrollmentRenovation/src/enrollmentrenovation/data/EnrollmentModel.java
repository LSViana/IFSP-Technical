package enrollmentrenovation.data;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.SchoolClass;
import enrollmentrenovation.business.User;
public interface EnrollmentModel extends EntityModel<Enrollment> {
    public Enrollment get(User Student, SchoolClass SchoolClass, Course Course) throws Exception;
    public Enrollment get(int IdStudent, int IdSchoolClass, int IdCourse) throws Exception;
    // Relationships
    public User getUser(Enrollment enrollment) throws Exception;
    public SchoolClass getSchoolClass(Enrollment enrollment) throws Exception;
    public Course getCourse(Enrollment enrollment) throws Exception;
}