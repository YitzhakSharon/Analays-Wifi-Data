import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Kml;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class testKML {

	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		final Kml kml = new Kml();
		Document document = kml.createAndSetDocument().withName("MyMarkers");

		document.createAndAddPlacemark().withName("London, UK").withOpen(Boolean.TRUE)  
		    .createAndSetPoint().addToCoordinates(-0.126236, 51.500152);    

		document.createAndAddPlacemark().withName("Somewhere near London,UK").withOpen(Boolean.TRUE)
		    .createAndSetPoint().addToCoordinates(-0.129800,52.70‌​0152);

}
}