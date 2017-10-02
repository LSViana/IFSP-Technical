package enrollmentrenovation.data;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Restriction;
import enrollmentrenovation.business.SchoolClass;
import java.util.List;
public interface DisciplineModel extends EntityModel<Discipline> {
    public Discipline get(int Id);
    public Discipline get(String Name);
    // Relationships
    public List<SchoolClass> getClasses();
    public List<CourseStructureModel> getStructure();
    public List<Credits> getCredits();
    public List<Restriction> getRequirements();
    public List<Restriction> getAchievements();
}
