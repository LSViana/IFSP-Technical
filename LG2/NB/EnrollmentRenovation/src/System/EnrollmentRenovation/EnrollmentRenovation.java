package System.EnrollmentRenovation;
import System.View.*;
import System.Business.*;
import System.Data.*;
import System.Services.*;
import java.sql.SQLException;
import java.util.List;

public class EnrollmentRenovation {
    private static ProjectService service;
    private static Login login;
    public static void main(String[] args) throws Exception {
        initializeService();
    }

    private static void initializeService() throws Exception {
        service = new ProjectService();
<<<<<<< HEAD
        login = new Login();
        login.setVisible(true);
=======
        List<State> st = service.getStates().getAll();
>>>>>>> bdd0f42b28f770b72dfe45b1102c63ba2d16d412
    }
}