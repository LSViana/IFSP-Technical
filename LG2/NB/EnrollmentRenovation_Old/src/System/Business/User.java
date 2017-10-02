package System.Business;
import java.lang.reflect.Field;
import java.time.LocalDate;
public class User extends EntityModel {
    static {
        ClassName = City.class.getCanonicalName();
        Fields = City.class.getDeclaredFields();
    }
    private Integer Id;
    private String FirstName;
    private String LastName;
    private LocalDate Birthday;
    private String Password;
    private Integer State;
    private Integer Type;
    private User() {
        // Standard constructor
    }
    public User(Integer Id, String FirstName, String LastName, LocalDate Birthday, String Password, Integer IdState, Integer Type) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Birthday = Birthday;
        this.Password = Password;
        this.State = IdState;
        this.Type = Type;
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
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public LocalDate getBirthday() {
        return Birthday;
    }
    public void setBirthday(LocalDate Birthday) {
        this.Birthday = Birthday;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public Integer getState() {
        return State;
    }
    public void setState(Integer IdState) {
        this.State = IdState;
    }
    public Integer getType() {
        return Type;
    }
    public void setType(Integer Type) {
        this.Type = Type;
    }   
}