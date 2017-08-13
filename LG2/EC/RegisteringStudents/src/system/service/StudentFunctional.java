package system.service;
import java.util.List;
import system.business.Student;
public interface StudentFunctional {
	public boolean register(String enrollment, String name, String email, String telephone);
	public List<Student> list();
	public List<Student> filter(String filter);
}
