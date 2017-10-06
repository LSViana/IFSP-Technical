package enrollmentrenovation.business;

import java.util.List;

public class Discipline {

    private int Id;
    private String Name;
    // Relationships
<<<<<<< HEAD
    private List<SchoolClass> SchoolClasses;
=======
    private List<SchoolClass> Classes;
>>>>>>> 37b16e240b9b74119f42a1fb17b8da50f7da7ef5
    private List<CourseStructure> Structure;
    private List<Credits> Credits;
    private List<Restriction> Requirements;
    private List<Restriction> Achievements;

<<<<<<< HEAD
    public Discipline(int Id, String Name, List<SchoolClass> SchoolClasses, List<CourseStructure> Structure, List<Credits> Credits, List<Restriction> Requirements, List<Restriction> Achievements) {
        this.Id = Id;
        this.Name = Name;
        this.SchoolClasses = SchoolClasses;
=======
    public Discipline(int Id, String Name, List<SchoolClass> Classes, List<CourseStructure> Structure, List<Credits> Credits, List<Restriction> Requirements, List<Restriction> Achievements) {
        this.Id = Id;
        this.Name = Name;
        this.Classes = Classes;
>>>>>>> 37b16e240b9b74119f42a1fb17b8da50f7da7ef5
        this.Structure = Structure;
        this.Credits = Credits;
        this.Requirements = Requirements;
        this.Achievements = Achievements;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public List<SchoolClass> getSchoolClasses() {
        return SchoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> SchoolClasses) {
        this.SchoolClasses = SchoolClasses;
    }

    public List<CourseStructure> getStructure() {
        return Structure;
    }

    public void setStructure(List<CourseStructure> Structure) {
        this.Structure = Structure;
    }

<<<<<<< HEAD
=======
    public List<CourseStructure> getStructure() {
        return Structure;
    }

    public void setStructure(List<CourseStructure> Structure) {
        this.Structure = Structure;
    }

>>>>>>> 37b16e240b9b74119f42a1fb17b8da50f7da7ef5
    public List<Credits> getCredits() {
        return Credits;
    }

    public void setCredits(List<Credits> Credits) {
        this.Credits = Credits;
    }

    public List<Restriction> getRequirements() {
        return Requirements;
    }

    public void setRequirements(List<Restriction> Requirements) {
        this.Requirements = Requirements;
    }

    public List<Restriction> getAchievements() {
        return Achievements;
    }

    public void setAchievements(List<Restriction> Achievements) {
        this.Achievements = Achievements;
    }
<<<<<<< HEAD

=======
    
>>>>>>> 37b16e240b9b74119f42a1fb17b8da50f7da7ef5
    
    
}
