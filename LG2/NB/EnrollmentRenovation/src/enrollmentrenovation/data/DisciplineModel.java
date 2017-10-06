package enrollmentrenovation.data;
import enrollmentrenovation.business.Credits;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Restriction;
import enrollmentrenovation.business.SchoolClass;
<<<<<<< HEAD
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
=======
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
>>>>>>> 37b16e240b9b74119f42a1fb17b8da50f7da7ef5
}
