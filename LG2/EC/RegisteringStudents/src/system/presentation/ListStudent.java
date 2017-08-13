package system.presentation;
import java.util.List;
import java.util.Scanner;
import system.business.Student;
import system.service.StudentFunctional;
public class ListStudent {
	StudentFunctional studentService;
	Scanner scanner;
	public ListStudent(StudentFunctional service) {
		this.studentService = service;
		scanner = new Scanner(System.in);
	}
	public void showAll() {
		System.out.println("\nFound students: ");
		List<Student> foundStudents = studentService.list();
		for (Student student : foundStudents) {
			System.out.println(student);
		}
		if(foundStudents.size() == 0) {
			try {
			Thread.sleep(10);
			System.err.println("No students found.");
			} catch(Exception exc) {
				// FODA-SE
			}
		}	
	}
	public void showFilter() {
		System.out.print("\nDigit a filter to apply to the data source: ");
		String filter = scanner.nextLine();
		System.out.println("\nFound students: ");
		List<Student> foundStudents = studentService.filter(filter);
		for (Student student : foundStudents) {
			System.out.println(student);
		}
		if(foundStudents.size() == 0) {
			try {
			Thread.sleep(10);
			System.err.println("No students found.");
			} catch(Exception exc) {
				// FODA-SE
			}
		}			
	}
}
