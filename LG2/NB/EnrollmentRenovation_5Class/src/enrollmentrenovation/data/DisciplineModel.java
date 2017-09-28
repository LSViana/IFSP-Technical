package enrollmentrenovation.data;
import java.sql.SQLException;
import enrollmentrenovation.business.Discipline;
public interface DisciplineModel extends EntityModel<Discipline> {
    public void update(int id, String name) throws Exception;
}
