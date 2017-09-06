package school;
import java.sql.SQLException;
import java.text.ParseException;
import school.control.StudentControl;
import school.view.Welcome;
public class Start {
	private static StudentControl studentControl = new StudentControl(); 
	public static void main(String[] args) throws ClassNotFoundException, ParseException, SQLException {
		new Welcome(studentControl).show();
	}
}
