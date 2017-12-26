package Filter;

import object.Scan;

public class NotFilter implements Filters {
	private Filters filter;

	public NotFilter() {
		this.filter=null;
	}
	public NotFilter(Filters filter) {
		this.filter=filter;
	}
	public boolean comper(Scan scan) {
		return !(this.filter.comper(scan));
	}
	
}
