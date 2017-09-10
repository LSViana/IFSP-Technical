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
    private String User;
    private String Password;
    private Integer IdState;
    private Integer Type;
    private User() {
        // Standard constructor
    }
    public User(Integer Id, String FirstName, String LastName, LocalDate Birthday, String User, String Password, Integer IdState, Integer Type) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Birthday = Birthday;
        this.User = User;
        this.Password = Password;
        this.IdState = IdState;
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
    public String getUser() {
        return User;
    }
    public void setUser(String User) {
        this.User = User;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public Integer getIdState() {
        return IdState;
    }
    public void setIdState(Integer IdState) {
        this.IdState = IdState;
    }
    public Integer getType() {
        return Type;
    }
    public void setType(Integer Type) {
        this.Type = Type;
    }   
}