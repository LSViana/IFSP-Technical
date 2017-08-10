package system.presentation;
import java.util.Scanner;
import system.business.Student;
import system.service.StudentFunctional;
public class RegisterStudent {
	private StudentFunctional studentService;
	private Scanner scanner;
	public RegisterStudent(StudentFunctional studentService) {
		this.studentService = studentService;
		scanner = new Scanner(System.in);
	}
	public void register() {
		System.out.print("Insert your enrollment: ");
		String $1 = scanner.nextLine();
		System.out.print("Insert your name: ");
		String $2 = scanner.nextLine();
		System.out.print("Insert your e-mail: ");
		String $3 = scanner.nextLine();
		System.out.print("Insert your telephone: ");
		String $4 = scanner.nextLine();
		//
		studentService.register($1, $2, $3, $4);
	}
}
