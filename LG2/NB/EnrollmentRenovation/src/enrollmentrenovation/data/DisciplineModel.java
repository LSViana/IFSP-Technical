package enrollmentrenovation.data;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.SchoolClass;
import enrollmentrenovation.business.CourseStructure;
import enrollmentrenovation.business.Restriction;
import java.util.List;
public interface DisciplineModel extends EntityModel<Discipline> {
    public Discipline get(int Id);
    public Discipline get(String Name);
    public List<SchoolClass> getClasses(Discipline discipline);
    public List<CourseStructure> getStructures(Discipline discipline);
    public List<Restriction> getRestrictions(Discipline discipline);
}