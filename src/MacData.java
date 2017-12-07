import java.util.Comparator;

public class MacData extends Cordinate{ //implements Comparator<MacData> {

	private Cordinate core;
	private int signal;
	private String mac;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MacData [core=" + core + ", Signal=" + signal + ", mac=" + mac + "]";
	}
	/**
	 * @return the core
	 */
	public Cordinate getCore() {
		return core;
	}
	/**
	 * @param core the core to set
	 */
	public void setCore(Cordinate core) {
		this.core = core;
	}
	/**
	 * @return the signal
	 */
	public int getSignal() {
		return signal;
	}
	/**
	 * @param signal the signal to set
	 */
	public void setSignal(int signal) {
		this.signal = signal;
	}
	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}
	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}
	public MacData(Cordinate core, int signal, String mac) {
		this.core = core;
		this.signal = signal;
		this.mac = mac;
	}

	public MacData() {
		super();
		signal = 0;
		this.mac = null;
	}
	public MacData(MacData other) {
		this.core=other.core;
		this.mac=other.mac;
		this.signal=other.signal;
	}
	public static Comparator<MacData> getCompBySignal()
	{   
	 Comparator comp = new Comparator<MacData>(){
			@Override
			public int compare(MacData o1, MacData o2) {
				if(o1.signal>o2.signal)
				// TODO Auto-generated method stub
				return 1;
				else return 0;
			}
	 };
	 return comp;
	}


}
