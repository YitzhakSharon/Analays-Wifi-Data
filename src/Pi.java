import java.util.Comparator;
import java.util.Date;

public class Pi {
	private MacData macdata;
	private double pi;
	/*
	 * tostring
	 * 
	 * @see java.lang.Object#toString()
	 */

	public Pi(MacData macdata, double pi) {
		this.macdata = macdata;
		this.pi = pi;
	}

	public Pi() {
		this.macdata = null;
		this.pi = 0;
	}

	public Pi(Pi other) {
		this.macdata = other.macdata;
		this.pi = other.pi;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pi [macdata=" + macdata + ", pi=" + pi + "]";
	}

	/**
	 * @return the macdata
	 */
	public MacData getMacdata() {
		return macdata;
	}

	/**
	 * @param macdata
	 *            the macdata to set
	 */
	public void setMacdata(MacData macdata) {
		this.macdata = macdata;
	}

	/**
	 * @return the pi
	 */
	public double getPi() {
		return pi;
	}

	/**
	 * @param pi
	 *            the pi to set
	 */
	public void setPi(double pi) {
		this.pi = pi;
	}

	public static Comparator<Pi> getCompByPi() {
		Comparator<Pi> com = new Comparator<Pi>() {
			@Override
			public int compare(Pi a, Pi b) {
				// TODO Auto-generated method stub
				if (a.getPi() < b.getPi())
					return 1;
				else
					return 0;
			}
		};
		return com;
	}

}
