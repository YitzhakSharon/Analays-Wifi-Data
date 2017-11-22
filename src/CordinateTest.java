import static org.junit.Assert.*;

import org.junit.Test;

public class CordinateTest {

	@Test
	public void testCordinate() {
		Cordinate core = new Cordinate();
		if(core.getAlt()!=0 && core.getLat()!=0 && core.getLon()!=0)
			fail("Not yet implemented");
	}

	@Test
	public void testCordinateDoubleDoubleDouble() {
		Cordinate core = new Cordinate(1,2,3);
		if(core.getLon()!=3 && core.getLat()!=2 && core.getAlt()!=3)
			fail("Not yet implemented");
	}

	@Test
	public void testCordinateCordinate() {
		Cordinate cord = new Cordinate(4,5,6);
		Cordinate core = new Cordinate(cord);
		if(core.getLon()!=4 && core.getLat()!=5 && core.getAlt()!=6)
			fail("Not yet implemented");
	}



	@Test
	public void testGetLon() {
		Cordinate cord = new Cordinate(4,5,6);
		if(cord.getLon()!=4)
			fail("Not yet implemented");
	}

	@Test
	public void testSetLon() {
		Cordinate cord = new Cordinate(4,5,6);
		cord.setLon(7);
		if(cord.getLon()!=7)
			fail("Not yet implemented");
	}

	@Test
	public void testGetLat() {
		Cordinate cord = new Cordinate(4,5,6);
		if(cord.getLat()!=5)
			fail("Not yet implemented");
	}

	@Test
	public void testSetLat() {
		Cordinate cord = new Cordinate(4,5,6);
		cord.setLat(8);
		if(cord.getLat()!=8)
			fail("Not yet implemented");
	}

	@Test
	public void testGetAlt() {
		Cordinate cord = new Cordinate(4,5,6);
		if(cord.getAlt()!=6)
			fail("Not yet implemented");
	}

	@Test
	public void testSetAlt() {
		Cordinate cord = new Cordinate(4,5,6);
		cord.setAlt(9);
		if(cord.getAlt()!=9)
			fail("Not yet implemented");
	}

	@Test
	public void testEqual() {
		Cordinate cord = new Cordinate(4,5,6);
		Cordinate core = new Cordinate(4,5,6);
		if(!cord.equal(cord, core))
			fail("Not yet implemented");
	}

}
