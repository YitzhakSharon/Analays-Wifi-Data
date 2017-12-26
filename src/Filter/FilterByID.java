package Filter;

import java.util.function.Predicate;

import object.Scan;

public class FilterByID implements Filters {
	private String id;
	
	public FilterByID(String id) {
		this.id=id;
	}
	

	public boolean comper(Scan scan) {
		return scan.getId().equals(this.id);
	}

}
