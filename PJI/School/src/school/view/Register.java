package school.view;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

import school.control.StudentControl;
import school.model.Student;
public class Register {
	private static StudentControl studentControl;
	public Register(StudentControl studentControl) {
		this.studentControl = studentControl;
	}
	public void show() throws ParseException, ClassNotFoundException, SQLException {
		MaskFormatter formatter = new MaskFormatter("######A");
		formatter.setValidCharacters("0123456789xX");
		JFormattedTextField enrollment = new JFormattedTextField(formatter);
		JTextField studentName = new JTextField();
		JSpinner age = new JSpinner(new SpinnerNumberModel(1, 1, 120, 1));
		//
		Object[] components = new Object[] {
			"Unique Ident.:", enrollment,
			"Student Name:", studentName,
			"Age:", age
		};
		Object[] options = new Object[] {
			"Save", "Return"	
		};
		//
		int choice = -1;
		do {
			choice = JOptionPane.showOptionDialog(null, components, "Registering Students", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
			if((int) age.getValue() < 18) {
				JOptionPane.showMessageDialog(null, "You can't register or save a Student with less than 18 years.", "Registering Students", JOptionPane.ERROR_MESSAGE);
				choice = 2; // Invalidate the current choice to show the dialog again
			}
			else if(choice == 0) {
				studentControl.insert(new Student(enrollment.getText(), studentName.getText(), (int)age.getValue()));
				choice = -1; // Makes the dialog close at the next iteration
			}
		} while(choice != -1 && choice != 1);
	}
}
