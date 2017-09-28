package enrollmentrenovation;

import enrollmentrenovation.business.*;
import enrollmentrenovation.data.*;
import enrollmentrenovation.service.*;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnrollmentRenovation {
    private static CityService cityService;
    
    public static void main(String[] args) {
        initializeService();
    }
    
    private static void initializeService() {
        cityService = new CityService();
        try {
            cityService.register(0, "Vitória", 0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnrollmentRenovation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentRenovation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}