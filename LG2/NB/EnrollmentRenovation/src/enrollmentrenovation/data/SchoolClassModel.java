package enrollmentrenovation.data;
import enrollmentrenovation.business.SchoolClass;
import enrollmentrenovation.business.Enrollment;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.Time;
import java.time.LocalDate;
import java.util.List;
public interface SchoolClassModel extends EntityModel<SchoolClass> {
    public SchoolClass get(int Id) throws Exception;
    // Relationships
    public Discipline getDiscipline(SchoolClass schoolClass) throws Exception;
    public Time getInitialTime(SchoolClass schoolClass) throws Exception;
    public Time getFinalTime(SchoolClass schoolClass) throws Exception;
    public LocalDate getInitialDate(SchoolClass schoolClass) throws Exception;
    public LocalDate getFinalDate(SchoolClass schoolClass) throws Exception;
    public List<Enrollment> getEnrollments(SchoolClass schoolClass) throws Exception;
}
