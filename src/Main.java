import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		// call the methods that make the csv file
		//FileCsv fe = new FileCsv();
		//fe.readForCsv("wiglewifi");
		// call the methods that make the kml file by filter
		FileKml fl = new FileKml();
		fl.readFromCsvToKml("Table.csv");
	}
}