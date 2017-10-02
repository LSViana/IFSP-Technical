package System.Business;
import java.lang.reflect.Field;
import java.time.LocalDate;
public class Class extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer Id;
    private Integer IdDiscipline;
    private Integer Day;
    private Integer IdInitialTime;
    private Integer IdFinalTime;
    private LocalDate InitialDate;
    private LocalDate EndDate;
    public Class(Integer Id, Integer IdDiscipline, Integer Day, Integer IdInitialTime, Integer IdFinalTime, LocalDate InitialDate, LocalDate EndDate) {
        this.Id = Id;
        this.IdDiscipline = IdDiscipline;
        this.Day = Day;
        this.IdInitialTime = IdInitialTime;
        this.IdFinalTime = IdFinalTime;
        this.InitialDate = InitialDate;
        this.EndDate = EndDate;
    }
    @Override
    public Integer[] getIds() {
        return new Integer[] { Id };
    }
    
    public Integer getId() {
        return Id;
    }
    public void setId(Integer Id) {
        this.Id = Id;
    }
    public Integer getIdDiscipline() {
        return IdDiscipline;
    }
    public void setIdDiscipline(Integer IdDiscipline) {
        this.IdDiscipline = IdDiscipline;
    }
    public Integer getDay() {
        return Day;
    }
    public void setDay(Integer Day) {
        this.Day = Day;
    }
    public Integer getIdInitialTime() {
        return IdInitialTime;
    }
    public void setIdInitialTime(Integer IdInitialTime) {
        this.IdInitialTime = IdInitialTime;
    }
    public Integer getIdFinalTime() {
        return IdFinalTime;
    }
    public void setIdFinalTime(Integer IdFinalTime) {
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