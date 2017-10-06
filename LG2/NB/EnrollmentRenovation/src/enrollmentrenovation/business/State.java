package enrollmentrenovation.business;

import java.util.List;

public class State {

    private int Id;
    private String Name;
    private String Initials;
    // Relationships
    private List<School> Schools;
    private List<User> Users;

    public State(int Id, String Name, String Initials, List<School> Schools, List<User> Users) {
        this.Id = Id;
        this.Name = Name;
        this.Initials = Initials;
        this.Schools = Schools;
        this.Users = Users;
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

    public String getInitials() {
        return Initials;
    }

    public void setInitials(String Initials) {
        this.Initials = Initials;
    }

    public List<School> getSchools() {
        return Schools;
    }

    public void setSchools(List<School> Schools) {
        this.Schools = Schools;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> Users) {
        this.Users = Users;
    }
    
    

}
