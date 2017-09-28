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
        initializeApplication();
    }

    private static void initializeService() throws Exception {
        service = new ProjectService();
    }

    private static void initializeApplication() {
        login = new Login(service);
        login.setVisible(true);
    }
}