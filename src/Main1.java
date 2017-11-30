import java.util.ArrayList;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileCsv fe = new FileCsv();
		fe.readForCsv("C:\\Users\\yitzhak\\Desktop\\Simple_1");
		// call the methods that make the kml file by filter
		FileKml fl = new FileKml();
		ArrayList <Scan>arrayOfscan =fl.readFromCsv("Table.csv");
		Algo1 temp =new Algo1 ();
		temp.algo1(arrayOfscan, "90:f6:52:28:38:19");

	}

}
