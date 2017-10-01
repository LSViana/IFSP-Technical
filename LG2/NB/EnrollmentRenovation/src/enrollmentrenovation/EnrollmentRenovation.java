package enrollmentrenovation;

import enrollmentrenovation.service.*;

public class EnrollmentRenovation {

    private static CityService cityService;
    private static CourseService courseService;
    private static DisciplineService disciplineService;
    private static StateService stateService;
    private static TimeService timeService;

    public static void main(String[] args) {
        initializeService();
    }

    private static void initializeService() {
        cityService = new CityService();
        courseService = new CourseService();
        disciplineService = new DisciplineService();
        stateService = new StateService();
        timeService = new TimeService();
    }
}