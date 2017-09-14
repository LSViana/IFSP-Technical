package system;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import system.business.Student;
import system.data.StudentDAO;
import system.presentation.ListStudent;
import system.presentation.RegisterStudent;
import system.service.StudentFunctional;
import system.service.StudentService;

public class start {
	static ListStudent listStudent;
	static StudentDAO stdDAO;
	static RegisterStudent registerStudent;
	static StudentFunctional service;
	static Scanner scanner;

	//
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Testing data class
		// stdDAO = new StudentDAO();
		// // stdDAO.insert(new Student("1650297", "Lucas Viana S. de Souza",
		// // "lv201122@gmail.com", "959521889"));
		// List<Student> students = stdDAO.searchAll();
		// for (Student student : students) {
		// System.out.println(student);
		// }
		// Common flow
		scanner = new Scanner(System.in);
		// (@Deprecated) Create the Service Layer
		// service = new StudentService();
		// Create the Data Access Object Layer
		stdDAO = new StudentDAO();
		// Create the windows instances
		listStudent = new ListStudent(service);
		registerStudent = new RegisterStudent(service);
		// Show the menu to the user
		System.out.println("\tWelcome to our Student register and managing system!");
		while (showMenu());
	}

	public static boolean showMenu() throws ClassNotFoundException, SQLException {
		int option = 0;
		System.out.println("\n\t1 - List All Students\n\t2 - Filter Student\n\t3 - Register Student\n\t4 - Delete Student\n\t5 - Update Students");
		//
		System.out.print("\nDigit your option: ");
		option = scanner.nextInt();
		switch (option) {
		case 0:
			return false;
		case 1:
			listStudent.showAll();
			break;
		case 2:
			listStudent.showFilter();
			break;
		case 3:
			registerStudent.register();
			break;
		case 4:
			listStudent.performDelete();
			break;
		case 5:
			listStudent.performUpdate();
			break;
		}
		return true;
	}
}
