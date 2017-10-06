package enrollmentrenovation.business;

import java.time.LocalDate;
import java.util.List;

public class SchoolClass {

    private int Id;
    private short Day;
    // Relationships
    private Discipline Discipline;
    private Time InitialTime;
    private Time FinalTime;
    private LocalDate InitialDate;
    private LocalDate FinalDate;
    private List<Enrollment> Students;

    public SchoolClass(int Id, short Day, Discipline Discipline, Time InitialTime, Time FinalTime, LocalDate InitialDate, LocalDate FinalDate, List<Enrollment> Students) {
        this.Id = Id;
        this.Day = Day;
        this.Discipline = Discipline;
        this.InitialTime = InitialTime;
        this.FinalTime = FinalTime;
        this.InitialDate = InitialDate;
        this.FinalDate = FinalDate;
        this.Students = Students;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public short getDay() {
        return Day;
    }

    public void setDay(short Day) {
        this.Day = Day;
    }

    public Discipline getDiscipline() {
        return Discipline;
    }

    public void setDiscipline(Discipline Discipline) {
        this.Discipline = Discipline;
    }

    public Time getInitialTime() {
        return InitialTime;
    }

    public void setInitialTime(Time InitialTime) {
        this.InitialTime = InitialTime;
    }

    public Time getFinalTime() {
        return FinalTime;
    }

    public void setFinalTime(Time FinalTime) {
        this.FinalTime = FinalTime;
    }

    public LocalDate getInitialDate() {
        return InitialDate;
    }

    public void setInitialDate(LocalDate InitialDate) {
        this.InitialDate = InitialDate;
    }

    public LocalDate getFinalDate() {
        return FinalDate;
    }

    public void setFinalDate(LocalDate FinalDate) {
        this.FinalDate = FinalDate;
    }

    public List<Enrollment> getStudents() {
        return Students;
    }

    public void setStudents(List<Enrollment> Students) {
        this.Students = Students;
    }
    
    

}
