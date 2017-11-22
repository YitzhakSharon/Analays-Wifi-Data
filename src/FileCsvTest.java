import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class FileCsvTest {

	@Test
	public void testGetPath() {
		FileCsv f = new  FileCsv("C:\\Users\\yitzhak\\Desktop\\wiglewifi");
		if(!f.getPath().equals("C:\\Users\\yitzhak\\Desktop\\wiglewifi"))
			fail("there is problem with the method GetPath");
	}

	@Test
	public void testSetPath() {
		FileCsv f = new  FileCsv("C:\\Users\\yitzhak\\Desktop\\wiglewifi");
		f.setPath("C:\\Users\\yitzhak\\Desktop\\Simple_1");
		if(!f.getPath().equals("C:\\Users\\yitzhak\\Desktop\\Simple_1"))
			fail("there is problem with the method SetPath");
	}

	@Test
	public void testFileCsvString() {
		FileCsv f = new  FileCsv("C:\\Users\\yitzhak\\Desktop\\wiglewifi");
		if(!f.getPath().equals("C:\\Users\\yitzhak\\Desktop\\wiglewifi"))
			fail("there is problem with the constractor");
	}


	@Test
	public void testFileCsvFileCsv() {
		FileCsv o = new  FileCsv("C:\\Users\\yitzhak\\Desktop\\wiglewifi");
		FileCsv temp = new  FileCsv(o);
		if(!temp.getPath().equals(o.getPath()))
			fail("there is problem with the copy constractor");
	}

	@Test
	public void testReadForCsv() {
		
		
		fail("Not yet implemented");
	}

	@Test
	public void testFindId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSotrByScan() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortAndWrite() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteWifiData() {
		fail("Not yet implemented");
	}

	@Test
	public void testChanneltoFrequncy() {
		FileCsv fe =new FileCsv();
		String fre=""+ 2412;
	if(!fe.ChanneltoFrequncy("1").equals(fre))
		fail("Not yet implemented");
	}

	@Test
	public void testIndexOfMaxRSSIWifi() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testWritecsv() {
		fail("Not yet implemented");
	}

}
