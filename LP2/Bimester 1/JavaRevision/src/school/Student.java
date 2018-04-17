package school;

public class Student {
	private String name;
	private int eyeColor;
	private String nation;
	
	public Student(String name, int eyeColor, String nation) {
		super();
		this.name = name;
		this.eyeColor = eyeColor;
		this.nation = nation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(int eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
}
