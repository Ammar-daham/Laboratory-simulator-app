package simu.model;


/**
 * @author Ammar Daham
 *
 */
public interface IDataAccessObject {
	public abstract boolean createData(Tulokset tulos);

	public abstract Tulokset[] readTulokset();

}
