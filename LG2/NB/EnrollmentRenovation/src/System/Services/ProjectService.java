package System.Services;
import System.Business.*;
import System.Data.*;
import System.Business.Class;
public class ProjectService {
    private EntityData<City> cities;
    private EntityData<Class> classes;
    private EntityData<Course> courses;
    private EntityData<CourseStructure> courseStructures;
    private EntityData<Credits> credits;
    private EntityData<Discipline> disciplines;
    private EntityData<Enrollment> enrollments;
    private EntityData<Restriction> restrictions;
    private EntityData<School> schools;
    private EntityData<State> states;
    private EntityData<Time> times;
    private EntityData<User> users;

    public ProjectService(/*EntityData<City> cities, EntityData<Business.Class> classes, EntityData<Course> courses, EntityData<CourseStructure> courseStructures, EntityData<Credits> credits, EntityData<Discipline> disciplines, EntityData<Enrollment> enrollments, EntityData<Restriction> restrictions, EntityData<School> schools, EntityData<State> states, EntityData<Time> times, EntityData<User> users*/) {
        this.cities = new EntityData();
        this.classes = new EntityData();
        this.courses = new EntityData();
        this.courseStructures = new EntityData();
        this.credits = new EntityData();
        this.disciplines = new EntityData();
        this.enrollments = new EntityData();
        this.restrictions = new EntityData();
        this.schools = new EntityData();
        this.states = new EntityData();
        this.times = new EntityData();
        this.users = new EntityData();
    }

    public EntityData<City> getCities() {
        return cities;
    }

    public void setCities(EntityData<City> cities) {
        this.cities = cities;
    }

    public EntityData<Class> getClasses() {
        return classes;
    }

    public void setClasses(EntityData<Class> classes) {
        this.classes = classes;
    }

    public EntityData<Course> getCourses() {
        return courses;
    }

    public void setCourses(EntityData<Course> courses) {
        this.courses = courses;
    }

    public EntityData<CourseStructure> getCourseStructures() {
        return courseStructures;
    }

    public void setCourseStructures(EntityData<CourseStructure> courseStructures) {
        this.courseStructures = courseStructures;
    }

    public EntityData<Credits> getCredits() {
        return credits;
    }

    public void setCredits(EntityData<Credits> credits) {
        this.credits = credits;
    }

    public EntityData<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(EntityData<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public EntityData<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(EntityData<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public EntityData<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(EntityData<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

    public EntityData<School> getSchools() {
        return schools;
    }

    public void setSchools(EntityData<School> schools) {
        this.schools = schools;
    }

    public EntityData<State> getStates() {
        return states;
    }

    public void setStates(EntityData<State> states) {
        this.states = states;
    }

    public EntityData<Time> getTimes() {
        return times;
    }

    public void setTimes(EntityData<Time> times) {
        this.times = times;
    }

    public EntityData<User> getUsers() {
        return users;
    }

    public void setUsers(EntityData<User> users) {
        this.users = users;
    }
    
}