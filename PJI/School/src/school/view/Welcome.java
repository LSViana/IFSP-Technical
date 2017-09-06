package school.view;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import school.control.StudentControl;

public class Welcome {
	private static Register register;
	private static Search search;
	private static StudentControl studentControl;
	public Welcome(StudentControl studentControl) {
		this.studentControl = studentControl;
		register = new Register(studentControl);
		search = new Search(studentControl);
	}
	
	public void show() throws ParseException, ClassNotFoundException, SQLException {
		Object[] options = new Object[] {
			"Register Student", "Search and List Students", "Exit"				
		};
		//
		int choice = -1;
		do {
		choice = JOptionPane.showOptionDialog(null, "Choose one of the following options: ", "Registering Students", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		switch(choice) {
		case 0:
			register.show();
			break;
		case 1:
			search.show();
			break;
		}
		} while(choice != -1 && choice != 2);
	}
}
