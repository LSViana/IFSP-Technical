package system.service;

import java.util.List;
import system.business.Student;
import system.data.StudentData;

public class StudentService implements StudentFunctional {

	public StudentData studentData;

	public StudentService() {
		studentData = new StudentData();
	}

	@Override
	public Student register(String enrollment, String name, String email, String telephone) {
		// Verify if the student is already registered
		if (studentData.exists(enrollment)) {
			throw new IllegalArgumentException("This enrollment is already registered, change the enrollment");
		}

		// Create an Student object, from business package
		Student student = new Student(enrollment, name, email, telephone);

		// Register the current student to the database
		studentData.insert(student);

		// Confirm the well-succeded execution
		return student;
	}

	@Override
	public List<Student> searchAll() {
		return studentData.getAll();
	}

	@Override
	public List<Student> filter(String filter) {
		return studentData.filter(filter);
	}

	@Override
	public void update(String enrollment, String studentName, String email, String telephone) {
		
	}

	@Override
	public int delete(String enrollment) {
		return 0;
	}

}
