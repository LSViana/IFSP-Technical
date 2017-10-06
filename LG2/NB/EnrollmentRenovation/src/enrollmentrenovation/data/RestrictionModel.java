package enrollmentrenovation.data;
import enrollmentrenovation.business.Restriction;
import enrollmentrenovation.business.Discipline;

public interface RestrictionModel extends EntityModel<Restriction> {
    public Restriction get(Discipline Required, Discipline Provided) throws Exception;
}