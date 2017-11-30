import java.text.ParseException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		// call the methods that make the csv file
		FileCsv fe = new FileCsv();
		fe.readForCsv("C:\\Users\\yitzhak\\Desktop\\Simple_1");
		
		// call the methods that make the kml file by filter
		FileKml fl = new FileKml();
		ArrayList <Scan>arrayOfscan =fl.readFromCsv("Table.csv");
		System.out.println();
		// call the method to creat kml by filter
		Filter ff = new Filter();
		ff.ChekFilterForKml(arrayOfscan);

		
	}
}