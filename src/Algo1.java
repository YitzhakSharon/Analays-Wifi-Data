import java.util.ArrayList;
import java.util.Collections;

public class Algo1 {

	private final int num=4;
	public Cordinate algo1 (ArrayList <Scan> scan, String mac) {
		ArrayList<MacData> onemac =new ArrayList<MacData> ();

		for (int i = 0; i < scan.size(); i++) {
			for (int j = 0; j < scan.get(i).getWifi().size(); j++) {
				if(scan.get(i).getWifi().get(j).getMAC().equals(mac)) {
					MacData temp= new MacData(scan.get(i).getCore(),Integer.parseInt(scan.get(i).getWifi().get(j).getSignal()),mac);
					onemac.add(temp);
				}
			} 
		}
		Collections.sort(onemac,MacData.getCompBySignal());

		ArrayList<MacData> one = new ArrayList<MacData>();
		for (int i = onemac.size()-num; i < onemac.size(); i++) {
			one.add(onemac.get(i));	
		}
		double wlon [] = new double [num];
		double wlat [] = new double [num];
		double walt [] = new double [num];
		double weight [] =new  double [num];

		for (int i = 0; i < num; i++) {
			weight[i]= findWeight(one.get(i).getSignal());
			wlon[i]= weightcore(weight[i],one.get(i).getLon());
			wlat[i]=weightcore(weight[i],one.get(i).getLat());
			walt[i]=weightcore(weight[i],one.get(i).getAlt());
		}
		double sumlon=0;
		double sumlat=0;
		double sumalt=0;
		double sumweight=0;

		for (int i = 0; i < num; i++) {
			sumlon=sumlon+ wlon[i];
			sumlat=sumlat +wlat[i];
			sumalt= sumalt+walt[i];
			sumweight=sumweight+weight[i];
		}
		Cordinate t = new Cordinate(sumlon/sumweight,sumlat/sumweight,sumalt/sumweight);
		return t;
	}

	public double findWeight(int signal) {
		return 1.0/(signal*signal);
	}
	public double weightcore(double core, double weight) {
		return weight*core;
	}

}
