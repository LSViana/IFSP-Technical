package enrollmentrenovation.data;

import java.sql.SQLException;
import enrollmentrenovation.business.City;
public interface CityModel extends EntityModel<City> {
    public void update(int id, String name, int idState) throws Exception;
}
