package system.data;
import java.util.ArrayList;
import java.util.List;

import system.business.Student;
public class StudentData implements StudentModel {
	
	private ArrayList<Student> students;
	
	public StudentData() {
		students = new ArrayList<>();
	}

	@Override
	public List<Student> getAll() {
		return students;
	}

	@Override
	public Student get(int index) {
		return students.get(index);
	}

	@Override
	public Student get(String enrollment) {
		for (Student student : students) {
			if(student.getEnrollment().contains(enrollment))
				return student;
		}
		return null;
	}

	@Override
	public boolean insert(Student student) {
		try {
			students.add(student);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean insertRange(List<Student> students) {
		try {
			for (Student student : students) {
				this.students.add(student);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean exists(String enrollment) {
		for (Student current : students) {
			if(enrollment.equals(current.getEnrollment()))
				return true;
		}
		return false;
	}

	@Override
	public List<Student> filter(String filter) {
		List<Student> result = new ArrayList<>();
		for (Student student : students) {
			if(student.getEnrollment().contains(filter))
				result.add(student);
		}
		return result;
	}
	
	
}
