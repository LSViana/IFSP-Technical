package system.presentation;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import system.business.Student;
import system.data.StudentDAO;
import system.service.StudentFunctional;
public class ListStudent {
//	StudentFunctional studentService;
	StudentDAO studentDAO;
	Scanner scanner;
	public ListStudent(StudentFunctional service) {
//		this.studentService = service;
		this.studentDAO = new StudentDAO();
		scanner = new Scanner(System.in);
	}
	public void showAll() throws ClassNotFoundException, SQLException {
		System.out.println("\nFound students: ");
//		List<Student> foundStudents = studentService.list();
		List<Student> foundStudents = studentDAO.searchAll();
		for (Student student : foundStudents) {
			System.out.println(student);
		}
		if(foundStudents.size() == 0) {
			try {
			System.out.println("No students found.");
			} catch(Exception exc) {
				// FODA-SE
			}
		}	
	}
	public void showFilter() throws ClassNotFoundException, SQLException {
		System.out.print("\nType an enrollment filter to apply to the data source: ");
		String filter = scanner.nextLine();
		System.out.println("\nFound students: ");
//		List<Student> foundStudents = studentService.filter(filter);
		List<Student> foundStudents = studentDAO.filter(filter);
		for (Student student : foundStudents) {
			System.out.println(student);
		}
		if(foundStudents.size() == 0) {
			try {
			System.out.println("No students found.");
			} catch(Exception exc) {
				// FODA-SE
			}
		}
	}
	
	public void performDelete() throws ClassNotFoundException, SQLException {
		System.out.print("\nType an enrollment to find students to delete: ");
		String enrollment = scanner.nextLine();
		int changes = studentDAO.delete(enrollment);
		System.out.printf("We found %d matches at the database and all of them were deleted.\n", changes);
	}
	
	public void performUpdate() throws ClassNotFoundException, SQLException {
		System.out.print("\nType an enrollment filter to find a student to update: ");
		String enrollment = scanner.nextLine();
		System.out.print("\tType a new name: ");
		String studentName = scanner.nextLine();
		System.out.print("\tType a new email: ");
		String email = scanner.nextLine();
		System.out.print("\tType a new telephone: ");
		String telephone = scanner.nextLine();
		studentDAO.update(enrollment, studentName, email, telephone);
	}
}
