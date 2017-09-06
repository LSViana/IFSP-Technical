package school.view;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import school.control.StudentControl;
import school.model.Student;

public class Search {
	private static StudentControl studentControl;
	private Object[] components;
	private Object[] options;
	private List<Student> students;

	public Search(StudentControl studentControl) {
		this.studentControl = studentControl;
	}

	public void show() throws ClassNotFoundException, SQLException, ParseException {
		loadComponents();
		//
		int choice = -1;
		do {
			choice = JOptionPane.showOptionDialog(null, components, "Registering Students", JOptionPane.NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, null);
			switch (choice) {
			case 1:
			case -1:
				return;
			case 0:
				String condition = ((JTextField) components[1]).getText().trim();
				searchStudents(condition);
			}
		} while (choice != -1 && choice != 1);
	}

	private void loadComponents() throws ClassNotFoundException, SQLException, ParseException {
		// Components
		// Searching for them
		searchStudents("");
		// Options
		options = new Object[] { "Search", "Return" };
	}

	private List<Student> searchStudents(String enrollment)
			throws ClassNotFoundException, SQLException, ParseException {
		JTextField searchField = new JTextField();
		students = studentControl.searchByEnrollment(enrollment);
		//JTableHeader header;
		Object[][] result = new Object[students.size()][3];
		JTable table;
		//
		if (students.size() == 0) {
			components = new Object[] { "Search by Enrollment: ", searchField,
					"Any data has been found, we are sorry! You can try again! :)" };
		} else {
			for (int i = 0; i < students.size(); i++) {
				// for (Student student : students) {
				result[i][0] = students.get(i).getEnrollment();
				result[i][1] = students.get(i).getStudentName();
				result[i][2] = students.get(i).getAge();
			}
			// model = new DefaultTableModel(result, new Object[] { "Enrollment", "Student
			// Name", "Age" });
			// table = new JTable(model);
			table = new JTable(result, new Object[] { "Enrollment", "Student Name", "Age" });
			components = new Object[] { "Search by Enrollment: ", searchField, "Found Data: ", table };
		}
		return students;
	}
}
