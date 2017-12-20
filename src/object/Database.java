package object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {

	private ArrayList<Scan>  database;
	/**
	 * empty contractor 
	 */
	public Database() {
		this.database=new ArrayList<Scan>();
	}
	/**
	 * contractor
	 * @param other
	 */
	public Database(Scan other) {
		this.database=new ArrayList<Scan>();
		this.database.add(other);
	}
	/**
	 * copy contractor
	 * @param other
	 */
	public Database (Database other) {
		this.database=new ArrayList<Scan>();
		this.database.clear();
		this.database.addAll(other.database);
	}
	/**
	 * add ArrayList to the database
	 * @param other
	 */
	public void addArrayList (ArrayList<Scan> other) {
		this.database.addAll(other);
		// we need to check douplicate
	}
	/**
	 * add one Scan
	 * @param other
	 */
	public void addScan (Scan other) {
		this.database.add(other);
	}

	/**
	 * clear the database
	 */
	public void cleardatabase () {
		this.database.clear();
	}

	/**
	 * that method turn ArrayList of Scan to hashMap for algo2
	 * @param scan
	 * @return
	 */

	public Map<String, ArrayList<Scan>> hashmap() {
		Map<String, ArrayList<Scan>> find = new HashMap<String, ArrayList<Scan>>();
		for (int i = 0; i < this.database.size(); i++) {
			for (int j = 0; j < this.database.get(i).getWifi().size(); j++) {
				if (find.containsKey(this.database.get(i).getWifi().get(j).getMAC()))
					find.get(this.database.get(i).getWifi().get(j).getMAC()).add(this.database.get(i));
				else {
					ArrayList<Scan> temp = new ArrayList<Scan>();
					temp.add(this.database.get(i));
					find.put(this.database.get(i).getWifi().get(j).getMAC(), temp);
				}
			}
		}
		return find;
	}

	public int numOfScan() {
		return this.database.size();
	}
	public int numOfmacs() {
		Map<String, ArrayList<Scan>> find= hashmap();
		return find.size();
	}
	/**
	 * toString 
	 */
public String toString(){
	return this.database.toString();
}
	/**
	 * @return the database
	 */
	public ArrayList<Scan> getDatabase() {
		return database;
	}
	/**
	 * @param database the database to set
	 */
	public void setDatabase(ArrayList<Scan> database) {
		this.database = database;
	}

}
