package enrollmentrenovation.business;

import java.util.ArrayList;

public class Course {

    private int Id;
    private String Name;
    private ArrayList<CourseStructure> Structure;
    private int IdSchool;

    public Course(int Id, String Name, int IdSchool) {
        this.Id = Id;
        this.Name = Name;
        this.IdSchool = IdSchool;
        Structure = new ArrayList<>();
    }

    public ArrayList<Discipline> getDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        for (CourseStructure cs : Structure) {
            disciplines.add(cs.getDiscipline());
        }
        return disciplines;
    }

    public void addDiscipline(Discipline Discipline, int Semester, boolean Facultative) {
        Structure.add(new CourseStructure(this, Discipline, Semester, Facultative));
    }

    public void deleteDiscipline(Discipline Discipline) {
        for (CourseStructure cs : Structure) {
            if(cs.getDiscipline().getName().equals(Discipline.getName())) {
                Structure.remove(cs);
            }
        }
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getIdSchool() {
        return IdSchool;
    }

    public void setIdSchool(int IdSchool) {
        this.IdSchool = IdSchool;
    }

}
