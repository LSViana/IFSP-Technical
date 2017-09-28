package enrollmentrenovation.data;

import java.sql.SQLException;
public interface CityModel {
    public void update(int id, String name, int idState) throws ClassNotFoundException, SQLException;
}
