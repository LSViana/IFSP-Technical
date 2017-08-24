package System.Business;
public class School implements EntityModel {
    private int Id;
    private int IdCity;
    public School(int Id, int IdCity) {
        this.Id = Id;
        this.IdCity = IdCity;
    }
    @Override
    public int[] getIds() {
        return new int[] { Id };
    }
    
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
    }
    public int getIdCity() {
        return IdCity;
    }
    public void setIdCity(int IdCity) {
        this.IdCity = IdCity;
    }
}