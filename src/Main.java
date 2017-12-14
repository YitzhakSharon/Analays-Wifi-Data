import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a =System.currentTimeMillis();
		FileCsv fe = new FileCsv();
		fe.readForCsv("C:\\Users\\yitzhak\\Desktop\\boaz1");

		FileKml fl = new FileKml();

		ArrayList<Scan> scan = fl.readFromCsv("Table.csv");
		ArrayList<Scan> sample = fl.readFromCsv("C:\\Users\\yitzhak\\Desktop\\_comb_no_gps_ts2_.csv");
		// Filter k = new Filter();
		// k.ChekFilterForKml(arrayOfscan);
		Algoritem temp1 = new Algoritem();
		temp1.algo2tocsv(scan, sample);
		temp1.algo1tocsv(scan);
		long b= System.currentTimeMillis();
		System.out.println(b-a);

	}

}
