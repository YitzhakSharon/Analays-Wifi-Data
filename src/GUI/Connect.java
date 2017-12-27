package GUI;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Algoritem.Algoritem;
import Files.FileCsv;
import Files.FileKml;
import Filter.ChooseFilter;
import Filter.Filter;
import Filter.FilterByID;
import Filter.FilterByPlace;
import Filter.FilterByTime;
import Filter.Filters;
import Filter.Makefilter;
import Filter.NotFilter;
import object.Database;
import object.MacData;
import object.Scan;
import object.Cordinate;

public class Connect {
	Database data;

	public Connect(){
		FileKml s=new FileKml();
		this.data= new Database();
	}
	
	public Cordinate algoritem1(String mac){
		Algoritem  l=new Algoritem();
		Map<String, ArrayList<MacData>> map =l.algo1Hash(this.data.getDatabase());
		Cordinate cor=new Cordinate(l.algo1(map,mac));
		return cor;
	}
	public void algoritem2a(String path){
		Algoritem  l=new Algoritem();
		FileKml s=new FileKml();
		l.algo2tocsv(this.data,s.readFromCsv(path));
	}
	public Cordinate algoritem2b(String mac1,String mac2,String mac3,String sig1,String sig2,String sig3){
		Algoritem  l=new Algoritem();
		Cordinate cor=new Cordinate( l.algo2fromUser(this.data,mac1,mac2,mac3,sig1,sig2,sig3));
		return cor;
	}

	public boolean check_user_macs(String mac) {
		String[] checkmac=mac.split(":");
		boolean flag = true;
		if(checkmac.length==6){
			for (int i = 0; i < checkmac.length; i++) {
				for (int j = 0; j < checkmac[i].length(); j++) {
					int ascii = (int)checkmac[i].charAt(j);
					if(!(ascii >=(int)'a' && ascii<= (int)'z') || !(ascii>=(int)'A' && ascii<=(int) 'Z') || !(ascii >='0' && ascii <= '9'))
						return false;
				}
			}
			return true;
		}
		else
			return false;	
	}

	public boolean check_user_Signal(String sig) {

		String k = sig.substring(1, sig.length());
		if(sig.length()>4)
			return false;
		for (int i = 0; i < k.length(); i++) {
			if(!((int)k.charAt(i)>='0' && (int)k.charAt(i)<='9')) {
				return false;
			}
		}
		return true;

	}


	public Database enterdatabase (String path) {
		FileCsv c = new FileCsv();
		this.data.addArrayList(c.readForCsv(path).getDatabase());
		return this.data;
	}

	public Database readCSv(String path) {
		if(!path.substring(path.length()-3, path.length()).equals("csv"))
			path=path+".csv";
		FileKml k = new FileKml();
		this.data.addArrayList(k.readFromCsv(path));
		return this.data;
	}

	public Database clear () {
		this.data.getDatabase().clear();
		this.data.getHash_map().clear();
		return this.data;
	}

	public void writeCSV(String name) {
		if (name.length()==0) 
			name="database.csv";

		else if(!name.substring(name.length()-3, name.length()).equals("csv"))
			name=name+".csv";
		FileCsv t = new FileCsv();
		try {
			System.out.println(this.data.getDatabase().size());
			System.out.println(name);
			t.writecsv(this.data.getDatabase(), name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}
	public void saveinkml (String name) {
		if(name.substring(name.length()-3, name.length()).equals("kml")) {
			name=name+".kml";
			FileKml k = new FileKml();
			k.TurnToKML(this.data.getDatabase(), name);
		}
	}
	public Filters notfiltertime(String min, String max){
		Filters time = new FilterByTime(min,max);
		Filters id2=new NotFilter(time); 
		return id2;
	}

	public Filters filtertime(String min, String max){
		Filters time = new FilterByTime(min,max);

		//	Set<Scan> k =t.filtering(this.data.getDatabase());
		//	ArrayList<Scan>h = new ArrayList<Scan>();
		//	h.addAll(k);
		//	this.data.setDatabase(h);
		return time;
	}
	public Filters filterplace (Cordinate cor, double rad){
		Filters place = new FilterByPlace(cor,rad) ;
		return place;
	}
	public Filters notfilterplace (Cordinate cor, double rad){
		Filters place = new FilterByPlace(cor,rad) ;
		Filters id2=new NotFilter(place); 
		return id2;
	}

	
	public Filters filterId (String id){
		Filters id1 = new FilterByID(id) ;
		return id1;
	}
	public Filters NOtfilterId (String id){
		Filters id1 = new FilterByID(id) ;
		Filters id2=new NotFilter(id1); 
		return id2;
	}

}