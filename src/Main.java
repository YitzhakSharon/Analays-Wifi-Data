import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileCsv fe = new FileCsv();
		//fe.readForCsv("wiglewifi");
		Filter k = new Filter();
		 FileKml fl = new FileKml();
		fl.readFromCsvToKml("Table.csv");
		// String k ="2017-10-28 20:19";
		// System.out.println(k.length())
	}
}
