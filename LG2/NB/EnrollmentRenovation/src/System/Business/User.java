package System.Business;
import java.time.LocalDate;
public class User implements EntityModel {
    private int Id;
    private String FirstName;
    private String LastName;
    private LocalDate Birthday;
    private String User;
    private String Password;
    private int IdState;
    private int Type;
    public User(int Id, String FirstName, String LastName, LocalDate Birthday, String User, String Password, int IdState, int Type) {
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
    public int[] getIds() {
        return new int[] { Id };
    }
    
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
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
    public int getIdState() {
        return IdState;
    }
    public void setIdState(int IdState) {
        this.IdState = IdState;
    }
    public int getType() {
        return Type;
    }
    public void setType(int Type) {
        this.Type = Type;
    }   
}