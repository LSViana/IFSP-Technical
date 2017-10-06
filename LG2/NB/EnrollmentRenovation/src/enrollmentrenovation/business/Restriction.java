package enrollmentrenovation.business;
public class Restriction {
    private Discipline Required;
    private Discipline Provided;

    public Restriction(Discipline Required, Discipline Provided) {
        this.Required = Required;
        this.Provided = Provided;
    }

    public Discipline getRequired() {
        return Required;
    }

    public void setRequired(Discipline Required) {
        this.Required = Required;
    }

    public Discipline getProvided() {
        return Provided;
    }

    public void setProvided(Discipline Provided) {
        this.Provided = Provided;
    }
    
    
}