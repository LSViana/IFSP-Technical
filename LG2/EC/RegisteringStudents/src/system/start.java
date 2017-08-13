package system;
import java.util.Scanner;
import system.presentation.ListStudent;
import system.presentation.RegisterStudent;
import system.service.StudentFunctional;
import system.service.StudentService;
public class start {
	static ListStudent listStudent;
	static RegisterStudent registerStudent;
	static StudentFunctional service;
	static Scanner scanner;
	//
	public static void main(String[] args) {
		scanner = new Scanner(System.in); 
		// Create the Service Layer
		service = new StudentService();
		// Create the windows instances
		listStudent = new ListStudent(service);
		registerStudent = new RegisterStudent(service);
		// Show the menu to the user
		System.out.println("\tWelcome to our Student register and managing system!");
		while(showMenu());
	}
	
	public static boolean showMenu() {
		int option = 0;
		System.out.println("\n\t1 - List All Students\n\t2 - Filter Student\n\t3 - Register Student");
		//
		System.out.print("\nDigit your option: ");
		option = scanner.nextInt();
		switch(option) {
		case 0: return false;
		case 1: listStudent.showAll(); break;
		case 2: listStudent.showFilter(); break;
		case 3: registerStudent.register();
		}
		return true;
	}
}
