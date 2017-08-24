package System.Business;
public class Restriction implements EntityModel {
    private int IdRequired;
    private int IdProvided;
    public Restriction(int IdRequired, int IdProvided) {
        this.IdRequired = IdRequired;
        this.IdProvided = IdProvided;
    }
    public int getIdRequired() {
        return IdRequired;
    }
    public void setIdRequired(int IdRequired) {
        this.IdRequired = IdRequired;
    }
    public int getIdProvided() {
        return IdProvided;
    }
    public void setIdProvided(int IdProvided) {
        this.IdProvided = IdProvided;
    }

    @Override
    public int[] getIds() {
        return new int[] { IdRequired, IdProvided };
    }
}
