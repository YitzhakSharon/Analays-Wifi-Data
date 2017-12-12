import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import javax.crypto.MacSpi;

public class Algoritem {

	private final static int num = 4;
	private final static int c1 = 1;
	private final static double f1_powrer = 0.5;
	private final static double f2_powrer = 2.0;
	
	public void algo1tocsv(ArrayList<Scan> scan) {
		ArrayList<MacData> write = new ArrayList<MacData>();
		ArrayList<String> mac = new ArrayList<String>();
		Cordinate temp = new Cordinate();
		for (int i = 0; i < scan.size(); i++) {
			for (int j = 0; j < scan.get(i).getWifi().size(); j++) {
				if (!mac.contains(scan.get(i).getWifi().get(j).getMAC())) {
					mac.add(scan.get(i).getWifi().get(j).getMAC());
					temp = algo1(scan, scan.get(i).getWifi().get(j).getMAC());
					MacData temp1 = new MacData(scan.get(i).getWifi().get(j), temp, scan.get(i).getTime());
					write.add(temp1);
				}
			}

		}
		writetocsv( write, "C:\\Users\\yitzhak\\Desktop\\rut.csv");
}


	
	
	public Cordinate algo1(ArrayList<Scan> scan, String mac) {
		ArrayList<MacData> onemac = new ArrayList<MacData>();
		onemac = scantomacdata(scan);
		ScanPredecate t = new ScanPredecate();
		onemac = t.filterls(onemac, t.SelectByMac(mac));
		Collections.sort(onemac, MacData.getCompBySignal());
		ArrayList<MacData> one = new ArrayList<MacData>();
		for (int i = onemac.size() - num; i < onemac.size(); i++) {
			if (i >= 0)
				one.add(onemac.get(i));
		}

		Cordinate cord = cor1(one);
		return cord;
	}

	public static ArrayList<MacData> scantomacdata(ArrayList<Scan> scan) {
		ArrayList<MacData> onemac = new ArrayList<MacData>();
		for (int i = 0; i < scan.size(); i++) {
			for (int j = 0; j < scan.get(i).getWifi().size(); j++) {
				MacData temp = new MacData(scan.get(i).getWifi().get(j), scan.get(i).getCore(), scan.get(i).getTime());
				onemac.add(temp);
			}
		}
		return onemac;
	}
	
	public void writetocsv(ArrayList<MacData> write, String path) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(path);
	
		PrintWriter outs = new PrintWriter(writer);
		for (int i = 0; i < write.size(); i++) {
			writer.append(i + "," + write.get(i).getMAC() + "," + write.get(i).getSSID() + ","
					+ write.get(i).getFrequncy() + "," + write.get(i).getSignal() + "," + write.get(i).getCore().getLon() + ","
					+ write.get(i).getCore().getLat()+ "," + write.get(i).getCore().getAlt() + "," + write.get(i).getTime());
			outs.println();
		}
		writer.close();
		System.out.println("csv for algo1 create complete,please chek file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Cordinate cor1(ArrayList<MacData> one) {
		double wlon[] = new double[one.size()];
		double wlat[] = new double[one.size()];
		double walt[] = new double[one.size()];
		double weight[] = new double[one.size()];

		for (int i = 0; i < one.size(); i++) {

			weight[i] = findWeight(Double.parseDouble(one.get(i).getSignal()));
			wlon[i] = weightcore(weight[i], one.get(i).getCore().getLon());
			wlat[i] = weightcore(weight[i], one.get(i).getCore().getLat());
			walt[i] = weightcore(weight[i], one.get(i).getCore().getAlt());
		}
		double sumlon = 0;
		double sumlat = 0;
		double sumalt = 0;
		double sumweight = 0;

		for (int i = 0; i < one.size(); i++) {
			sumlon = sumlon + wlon[i];
			sumlat = sumlat + wlat[i];
			sumalt = sumalt + walt[i];
			sumweight = sumweight + weight[i];
		}
		return new Cordinate(sumlon / sumweight, sumlat / sumweight, sumalt / sumweight);
	}



	// public Cordinate algo1( String mac) {
	// onemac = ScanPredecate.filterls(this.onemac, ScanPredecate.SelectByMac(mac));
	// Collections.sort(onemac, MacData.getCompBySignal());
	// ArrayList<MacData> one = new ArrayList<MacData>();
	// for (int i = onemac.size() - num; i < onemac.size(); i++) {
	// if (i >= 0)
	// one.add(this.onemac.get(i));
	// }
	//
	// Cordinate cord = cor1(one);
	// return cord;
	// }

	public static double findWeight(double signal) {
		return 1.0 / (signal * signal);
	}

	public static double weightcore(double core, double weight) {
		return weight * core;
	}
//
//	public Cordinate algo2(ArrayList<Scan> scan, ArrayList<MacData> sample) {
//		for (int i = 0; i < scan.size(); i++) {
//			for (int j = 0; j < scan.get(i).getWifi().size(); j++) {
//				for (int j2 = 0; j2 < sample.size(); j2++) {
//					if (!scan.get(i).getWifi().get(j).getMAC().equals(sample.get(j2).getMac()))
//						scan.remove(scan.get(i));
//				}
//			}
//		}
//
//		ArrayList<Pi> data = matrix(scan, sample);
//		Collections.sort(data, Pi.getCompByPi());
//		ArrayList<Pi> fordata = new ArrayList<Pi>();
//		for (int i = data.size() - 1; i > data.size() - num; i--) {
//			fordata.add(data.get(i));
//
//		}
//
//		Cordinate rt = cor2(fordata);
//		return rt;
//	}
//
//	public static ArrayList<Pi> matrix(ArrayList<Scan> macs, ArrayList<MacData> sample) {
//		String[][] approximation = new String[2][sample.size()];
//		ArrayList<Pi> data = new ArrayList<Pi>();
//		for (int i = 0; i < sample.size(); i++) {
//			approximation[0][i] = sample.get(i).getMac();
//			approximation[1][i] = "" + sample.get(i).getSignal();
//			;
//		}
//
//		for (int i = 0; i < macs.size(); i++) {
//			// approximation[i + 2][0] = "" + macs.get(i).getCore().getLat();
//			// approximation[i + 2][1] = "" + macs.get(i).getCore().getLon();
//			// approximation[i + 2][2] = "" + macs.get(i).getCore().getAlt();
//			double pi = 1;
//			for (int k = 0; k < sample.size(); k++) {
//				String signal = "" + -120;
//				;
//				for (int j = 0; j < macs.get(i).getWifiNetWork(); j++) {
//					if (macs.get(i).getWifi().get(j).getMAC().equals(approximation[0][k]))
//
//						signal = "" + macs.get(i).getWifi().get(j).getSignal();
//				}
//				double w = findw(signal, approximation[1][k]);
//				pi = pi * w;
//
//			}
//			MacData macdata = new MacData(macs.get(i).getCore(),
//					Integer.parseInt(macs.get(i).getWifi().get(0).getSignal()), macs.get(i).getWifi().get(0).getMAC());
//			Pi temp = new Pi(macdata, pi);
//			data.add(temp);
//		}
//
//		return data;
//
//	}

//	public static double findw(String signal1, String signal) {
//		double dif;
//		if (Double.parseDouble(signal1) != -120)
//			dif = Math.abs(Double.parseDouble(signal1) - Double.parseDouble(signal)) + c1;
//		else
//			dif = 80;
//		double f1 = 1.0 / Math.pow(dif, f1_powrer);
//		double f2 = 1.0 / Math.pow(Double.parseDouble(signal), f2_powrer);
//		double result = f1 * f2;
//		return result;
//
//	}


//
//	public static Cordinate cor2(ArrayList<Pi> one) {
//		double wlon[] = new double[one.size()];
//		double wlat[] = new double[one.size()];
//		double walt[] = new double[one.size()];
//		double weight[] = new double[one.size()];
//
//		for (int i = 0; i < one.size(); i++) {
//			weight[i] = one.get(i).getPi();
//			wlon[i] = weightcore(one.get(i).getPi(), one.get(i).getMacdata().getCore().getLon());
//			wlat[i] = weightcore(one.get(i).getPi(), one.get(i).getMacdata().getCore().getLat());
//			walt[i] = weightcore(one.get(i).getPi(), one.get(i).getMacdata().getCore().getAlt());
//		}
//		double sumlon = 0;
//		double sumlat = 0;
//		double sumalt = 0;
//		double sumweight = 0;
//
//		for (int i = 0; i < one.size(); i++) {
//			sumlon = sumlon + wlon[i];
//			sumlat = sumlat + wlat[i];
//			sumalt = sumalt + walt[i];
//			sumweight = sumweight + weight[i];
//		}
//		return new Cordinate(sumlon / sumweight, sumlat / sumweight, sumalt / sumweight);
//	}

}
