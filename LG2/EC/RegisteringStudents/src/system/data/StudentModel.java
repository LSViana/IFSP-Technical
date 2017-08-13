package system.data;
import java.util.List;
import system.business.Student;
public interface StudentModel {
	public List<Student> getAll();
	public Student get(int index);
	public Student get(String enrollment);
	public List<Student> filter(String filter);
	public boolean insert(Student student);
	public boolean insertRange(List<Student> students);
	public boolean exists(String enrollment);
}
