package school;

public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student("Lucas", 0xFFFFF, "Brazil");
		Student s2 = new Student("Glayson", 0x00FF25, "Camarões");
		System.out.println(s1);
		System.out.println(s2.hashCode());
	}
	
	public static void VouPrintar(Object obj) {
		VouPrintar(obj.toString());
	}
	
	public static void VouPrintar(String str) {
		System.out.println(str);
	}
}
