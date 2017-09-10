package System.Services;
import System.Business.*;
import System.Data.*;
import System.Business.Class;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProjectService {
    static {
        for(java.lang.reflect.Field f : ProjectService.class.getDeclaredFields()) {
            try {
                java.lang.Class.forName("System.Business." + f.getName());
            } catch (Exception ex) {
               // Sem Tratamento Disponível
            }
        }
    }
    
    private EntityData<City> City;
    private EntityData<Class> Class;
    private EntityData<Course> Course;
    private EntityData<CourseStructure> CourseStructure;
    private EntityData<Credits> Credits;
    private EntityData<Discipline> Discipline;
    private EntityData<Enrollment> Enrollment;
    private EntityData<Restriction> Restriction;
    private EntityData<School> School;
    private EntityData<State> State;
    private EntityData<Time> Time;
    private EntityData<User> User;

    public ProjectService(/*EntityData<City> City,
    EntityData<Business.Class> Class,
    EntityData<Course> Course,
    EntityData<CourseStructure> CourseStructure,
    ntityData<Credits> Credit,
    EntityData<Discipline> Discipline,
    EntityData<Enrollment> Enrollment,
    EntityData<Restriction> Restriction,
    ntityData<School> School,
    EntityData<State> State,
    ntityData<Time> Time,
    ntityData<User> User*/) throws Exception {
        this.City = new EntityData(City.class);
        this.Class = new EntityData(Class.class);
        this.Course = new EntityData(Course.class);
        this.CourseStructure = new EntityData(CourseStructure.class);
        this.Credits = new EntityData(Credits.class);
        this.Discipline = new EntityData(Discipline.class);
        this.Enrollment = new EntityData(Enrollment.class);
        this.Restriction = new EntityData(Restriction.class);
        this.School = new EntityData(School.class);
        this.State = new EntityData(State.class);
        this.Time = new EntityData(Time.class);
        this.User = new EntityData(User.class);
    }

    public EntityData<City> getCities() {
        return City;
    }

    public void setCities(EntityData<City> cities) {
        this.City = cities;
    }

    public EntityData<Class> getClasses() {
        return Class;
    }

    public void setClasses(EntityData<Class> classes) {
        this.Class = classes;
    }

    public EntityData<Course> getCourses() {
        return Course;
    }

    public void setCourses(EntityData<Course> courses) {
        this.Course = courses;
    }

    public EntityData<CourseStructure> getCourseStructures() {
        return CourseStructure;
    }

    public void setCourseStructures(EntityData<CourseStructure> courseStructures) {
        this.CourseStructure = courseStructures;
    }

    public EntityData<Credits> getCredits() {
        return Credits;
    }

    public void setCredits(EntityData<Credits> credits) {
        this.Credits = credits;
    }

    public EntityData<Discipline> getDisciplines() {
        return Discipline;
    }

    public void setDisciplines(EntityData<Discipline> disciplines) {
        this.Discipline = disciplines;
    }

    public EntityData<Enrollment> getEnrollments() {
        return Enrollment;
    }

    public void setEnrollments(EntityData<Enrollment> enrollments) {
        this.Enrollment = enrollments;
    }

    public EntityData<Restriction> getRestrictions() {
        return Restriction;
    }

    public void setRestrictions(EntityData<Restriction> restrictions) {
        this.Restriction = restrictions;
    }

    public EntityData<School> getSchools() {
        return School;
    }

    public void setSchools(EntityData<School> schools) {
        this.School = schools;
    }

    public EntityData<State> getStates() {
        return State;
    }

    public void setStates(EntityData<State> states) {
        this.State = states;
    }

    public EntityData<Time> getTimes() {
        return Time;
    }

    public void setTimes(EntityData<Time> times) {
        this.Time = times;
    }

    public EntityData<User> getUsers() {
        return User;
    }

    public void setUsers(EntityData<User> users) {
        this.User = users;
    }
    
}