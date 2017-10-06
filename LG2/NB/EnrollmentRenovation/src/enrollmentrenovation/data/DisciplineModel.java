package enrollmentrenovation.data;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Restriction;
import enrollmentrenovation.business.SchoolClass;
import enrollmentrenovation.business.CourseStructure;
import java.util.List;
public interface DisciplineModel extends EntityModel<Discipline> {
    public Discipline get(int Id) throws Exception;
    public Discipline get(String Name) throws Exception;
    // Relationships
    public List<SchoolClass> getSchoolClasses(Discipline discipline) throws Exception;
    public List<CourseStructure> getStructures(Discipline discipline) throws Exception;
    public List<Credits> getCredits(Discipline discipline) throws Exception;
    public List<Restriction> getRequirements(Discipline discipline) throws Exception;
    public List<Restriction> getAchievements(Discipline discipline) throws Exception;
}
