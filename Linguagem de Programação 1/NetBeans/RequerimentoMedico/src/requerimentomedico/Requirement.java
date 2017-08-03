package requerimentomedico;
import java.time.LocalDate;
public class Requirement {
    public Requirement(String studentName, int enrollment, int classNumber, int time, String description, LocalDate dateOcurrence, int type, int status, LocalDate sentDate, String obs) {
        this.studentName = studentName;
        this.enrollment = enrollment;
        this.classNumber = classNumber;
        this.time = time;
        this.description = description;
        this.dateOcurrence = dateOcurrence;
        this.type = type;
        this.status = status;
        this.sentDate = sentDate;
        this.obs = obs;
    }
    //
    String studentName;
    int enrollment;
    int classNumber;
    int time;
    String description;
    LocalDate dateOcurrence;
    int type;
    //
    int status;
    LocalDate sentDate;
    String obs;
}