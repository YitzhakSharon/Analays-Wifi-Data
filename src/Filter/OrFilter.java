package Filter;

import object.Scan;

public class OrFilter implements Filters {

	private Filters filter_1;
	private Filters filter_2;
	
	public OrFilter() {
		this.filter_1=null;
		this.filter_2=null;
		
	}
	public OrFilter(Filters f1 , Filters  f2) {
		this.filter_1=f1;
		this.filter_2=f2;
	}
	
	public boolean comper(Scan scan) {
		return this.filter_1.comper(scan) || this.filter_2.comper(scan);
	}

}
