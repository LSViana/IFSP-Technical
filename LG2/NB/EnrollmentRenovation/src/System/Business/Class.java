package System.Business;
import java.time.LocalDate;
public class Class implements EntityModel {
    private int Id;
    private int IdDiscipline;
    private int Day;
    private int IdInitialTime;
    private int IdFinalTime;
    private LocalDate InitialDate;
    private LocalDate EndDate;
    public Class(int Id, int IdDiscipline, int Day, int IdInitialTime, int IdFinalTime, LocalDate InitialDate, LocalDate EndDate) {
        this.Id = Id;
        this.IdDiscipline = IdDiscipline;
        this.Day = Day;
        this.IdInitialTime = IdInitialTime;
        this.IdFinalTime = IdFinalTime;
        this.InitialDate = InitialDate;
        this.EndDate = EndDate;
    }
    @Override
    public int[] getIds() {
        return new int[] { Id };
    }
    
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public int getIdDiscipline() {
        return IdDiscipline;
    }
    public void setIdDiscipline(int IdDiscipline) {
        this.IdDiscipline = IdDiscipline;
    }
    public int getDay() {
        return Day;
    }
    public void setDay(int Day) {
        this.Day = Day;
    }
    public int getIdInitialTime() {
        return IdInitialTime;
    }
    public void setIdInitialTime(int IdInitialTime) {
        this.IdInitialTime = IdInitialTime;
    }
    public int getIdFinalTime() {
        return IdFinalTime;
    }
    public void setIdFinalTime(int IdFinalTime) {
        this.IdFinalTime = IdFinalTime;
    }
    public LocalDate getInitialDate() {
        return InitialDate;
    }
    public void setInitialDate(LocalDate InitialDate) {
        this.InitialDate = InitialDate;
    }
    public LocalDate getEndDate() {
        return EndDate;
    }
    public void setEndDate(LocalDate EndDate) {
        this.EndDate = EndDate;
    }
}