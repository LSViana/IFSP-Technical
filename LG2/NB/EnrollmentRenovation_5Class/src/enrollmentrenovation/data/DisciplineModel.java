package enrollmentrenovation.data;
import java.sql.SQLException;
public interface DisciplineModel {
    public void update(int id, String name) throws ClassNotFoundException, SQLException;
}
