package Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class patientInfo {
	private ArrayList<Map<String, String>> patientDB = new ArrayList<Map<String, String>>();
	private int monitorPeriod;
	
	public void storeInfo(String s) throws Exception{
		File dataFile = new File(s);
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		String name = "";
		String patientPeriod = "";
		
		
		String line = reader.readLine();
		monitorPeriod = Integer.parseInt(line);
		line = reader.readLine();
		while(line != null) {
			String[] info = line.split(" ");
			if (info[0].compareTo("patient") == 0) {
				name = info[1];
				patientPeriod = info[2];
			}
			else {
				Map<String, String> entry = new HashMap<String, String>();
				entry.put("patientName", name);
				entry.put("patientPeriod", patientPeriod);
				entry.put("sensorCategory", info[0]);
				entry.put("sensorName", info[1]);
				entry.put("dataset", info[2]);
				entry.put("lowerBound", info[3]);
				entry.put("upperBound", info[4]);
				patientDB.add(entry);
			}
			line = reader.readLine();
		}
		reader.close();
	}
	
	public int getMonitorPeriod() {
		return monitorPeriod;
	}
	
	public ArrayList<Map<String, String>> getInfo() {
		return patientDB;
	}
}