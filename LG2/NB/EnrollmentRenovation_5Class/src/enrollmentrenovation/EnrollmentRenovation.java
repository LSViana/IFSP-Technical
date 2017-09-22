package enrollmentrenovation;

import enrollmentrenovation.business.City;
import enrollmentrenovation.business.Course;
import enrollmentrenovation.business.Discipline;
import enrollmentrenovation.business.State;
import enrollmentrenovation.business.Time;
import enrollmentrenovation.data.CityDAO;
import enrollmentrenovation.data.CourseDAO;
import enrollmentrenovation.data.DisciplineDAO;
import enrollmentrenovation.data.StateDAO;
import enrollmentrenovation.data.TimeDAO;
import enrollmentrenovation.service.DbService;
import java.time.LocalTime;

public class EnrollmentRenovation {
    private static DbService service;
    public static void main(String[] args) throws Exception {
        service = new DbService();
        service.getTimeDAO().insert(new Time(0, LocalTime.of(7, 0, 0)));
        service.getTimeDAO().insert(new Time(0, LocalTime.of(7, 45, 0)));
        service.getTimeDAO().insert(new Time(0, LocalTime.of(8, 30, 0)));
        service.getTimeDAO().insert(new Time(0, LocalTime.of(9, 15, 0)));
        service.getTimeDAO().insert(new Time(0, LocalTime.of(10, 0, 0)));
    }
}