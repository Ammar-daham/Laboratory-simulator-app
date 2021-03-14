package simu.model;

import java.util.ArrayList;



/**
 * Date: March 10-2021.
 * This class is for reading the data from the database
 * @author Ammar Daham
 *
 */

public class ReadData {
	
	private ArrayList<Tulokset> tulokset = new ArrayList<>();
	
	private DataAccessObject DataDAO;
	
	/**
	 * Parameterless constructor.
	 */
	public ReadData() {
		DataDAO = new DataAccessObject();
		Tulokset[] tulosArr = DataDAO.readTulokset();
		for(Tulokset v : tulosArr) {
			tulokset.add(v);
		}
	}
	
	
	
	/**
	 * This method for getting a list of data
	 * @return List of data.
	 */
	public String[] getVaihtoehdot() {
		String[] tulokset1 = new String[tulokset.size()];
		for(int i = 0; i < tulokset.size(); i++) {
			tulokset1[i] = tulokset.get(i).toString();
		}
		return tulokset1;
	}


}
