package system.business;

public class Student {
	private String enrollment;
	private String name;
	private String email;
	private String telephone;
	//
	public Student(String enrollment, String name, String email, String telephone) {
		super();
		this.enrollment = enrollment;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
	}
	// 
	public String getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	//
	@Override
	public String toString() {
		return getEnrollment() + " - " + getName() + " - " + getEmail() + " - " + getTelephone();
	}
}
