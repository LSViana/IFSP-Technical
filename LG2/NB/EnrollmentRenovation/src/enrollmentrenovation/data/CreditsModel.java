package enrollmentrenovation.data;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.User;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Course;
public interface CreditsModel extends EntityModel<Credits> {
    public Credits get(User Student, Discipline Discipline, Course Course) throws Exception;
    public Credits get(int IdStudent, int IdDiscipline, int IdCourse) throws Exception;
    // Relationships
    public User getUser(Credits credits) throws Exception;
    public Discipline getDiscipline(Credits credits) throws Exception;
    public Course getCourse(Credits credits) throws Exception;
}
