package enrollmentrenovation.data;
import enrollmentrenovation.business.City;
public interface CityModel extends EntityModel<City> {
    public City get(int Id) throws Exception;
    public City get(String Name) throws Exception;
    public State getState(City city) throws Exception;
}
