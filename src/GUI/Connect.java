package GUI;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Algoritem.Algoritem;
import Files.FileKml;
import object.Database;
import object.MacData;
import object.Scan;
import object.Cordinate;

public class Connect {
	Database data;
	
	public Connect(){
		 FileKml s=new FileKml();
		 this.data= new Database();
		 this.data.addArrayList(s.readFromCsv("Table.csv"));
		 this.data.hashmap();
	}
	public void algoritem1(String mac){
	Algoritem  l=new Algoritem();
	 Map<String, ArrayList<MacData>> map =l.algo1Hash(this.data.getDatabase());
	 Cordinate cor=new Cordinate(l.algo1(map,mac));
	 System.out.println(cor.toString());
	}
	public void algoritem2a(String path){
    Algoritem  l=new Algoritem();
   FileKml s=new FileKml();
   l.algo2tocsv(this.data,s.readFromCsv(path));
	}
	public void algoritem2b(String mac1,String mac2,String mac3,String sig1,String sig2,String sig3){
	   Algoritem  l=new Algoritem();
	   Cordinate cor=new Cordinate( l.algo2fromUser(this.data,mac1,mac2,mac3,sig1,sig2,sig3));
		 System.out.println(cor.toString());
		}
}