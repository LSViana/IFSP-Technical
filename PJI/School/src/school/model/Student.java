package school.model;

public class Student {
	private String enrollment;
	private String studentName;
	private int age;
	public String getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String enrollment, String studentName, int age) {
		super();
		this.enrollment = enrollment;
		this.studentName = studentName;
		this.age = age;
	}
}
