package enrollmentrenovation.service;

import enrollmentrenovation.data.CityDAO;
import enrollmentrenovation.data.CourseDAO;
import enrollmentrenovation.data.DisciplineDAO;
import enrollmentrenovation.data.StateDAO;
import enrollmentrenovation.data.TimeDAO;

public class DbService {

    private CityDAO cityDAO = new CityDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private DisciplineDAO disciplineDAO = new DisciplineDAO();
    private StateDAO stateDAO = new StateDAO();
    private TimeDAO timeDAO = new TimeDAO();

    public DbService() {
        // Standard Constructor
    }

    public CityDAO getCityDAO() {
        return cityDAO;
    }

    public void setCityDAO(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public CourseDAO getCourseDAO() {
        return courseDAO;
    }

    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public DisciplineDAO getDisciplineDAO() {
        return disciplineDAO;
    }

    public void setDisciplineDAO(DisciplineDAO disciplineDAO) {
        this.disciplineDAO = disciplineDAO;
    }

    public StateDAO getStateDAO() {
        return stateDAO;
    }

    public void setStateDAO(StateDAO stateDAO) {
        this.stateDAO = stateDAO;
    }

    public TimeDAO getTimeDAO() {
        return timeDAO;
    }

    public void setTimeDAO(TimeDAO timeDAO) {
        this.timeDAO = timeDAO;
    }
    
    
}
