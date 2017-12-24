package GUI;


import java.util.ArrayList;
import java.util.Map;

import Algoritem.Algoritem;
import Files.FileKml;
import object.Database;
import object.MacData;
import object.Cordinate;

public class Connect {
	Database data;
	
	public Connect(){
		 FileKml s=new FileKml();
		 this.data= new Database();
		 this.data.addArrayList(s.readFromCsv("Table.csv"));
	}
	public void algoritem1(String mac){
	Algoritem  l=new Algoritem();
	 Map<String, ArrayList<MacData>> map =l.algo1Hash(this.data.getDatabase());
	 Cordinate cor=new Cordinate(l.algo1(map,mac));
	 System.out.println(cor.toString());
	}
	public void algoritem2path(String path){
    Algoritem  l=new Algoritem();
   FileKml s=new FileKml();
   l.algo2tocsv(this.data,s.readFromCsv(path));
	}
}
