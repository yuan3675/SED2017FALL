package MonitorControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class MonitorControl {
	private ArrayList<Map<String, String>> patientDB;
	
	public void monitor(int time, ArrayList<Map<String, String>> DB) throws Exception{
		patientDB = DB;	
		for(int i = 0; i <= time; i++) {
			for(int j = 0; j < patientDB.size(); j++) {
				int monitorPeriod = Integer.parseInt(patientDB.get(j).get("patientPeriod"));
				if ((i % monitorPeriod) == 0) {
					String datasetName = patientDB.get(j).get("dataset");
					File dataFile = new File(datasetName);
					BufferedReader reader = new BufferedReader(new FileReader(dataFile));
					int index = i / monitorPeriod;
					String line = "";
					
					for (int k = 0; k <= index; k++) {
						line = reader.readLine(); 
					}
					if(line == null)line = "-1";
					double value = Double.parseDouble(line);
					double lowerBound = Double.parseDouble(patientDB.get(j).get("lowerBound"));
					double upperBound = Double.parseDouble(patientDB.get(j).get("upperBound"));
					patientDB.get(j).put("record" + Integer.toString(index), "[" + Integer.toString(i) + "] " + Double.toString(value));
					
					if(value < lowerBound || value > upperBound) {
						this.alert(value, i, j);
					}
					reader.close();
				}
			}
		}
		this.display(patientDB, time);
	}
	
	private void alert(double value, int time, int index) {
		
		if(value == -1){
			System.out.println("[" + time + "] " + patientDB.get(index).get("sensorName") + " falls"); 
		}
		else {
			System.out.println("[" + time + "] " + patientDB.get(index).get("patientName") + " is in danger! Cause: " + patientDB.get(index).get("sensorName") + " " + value);
		}
	}
	
	private void display(ArrayList<Map<String, String>> DB, int time) {
		String pName = DB.get(0).get("patientName");
		System.out.println("patient " + pName);
		for (int i = 0; i < DB.size(); i++) {
			String name = DB.get(i).get("patientName");
			if(name.compareTo(pName) != 0) {
				System.out.println("patient " + name);
				pName = name;
			}
			System.out.println(DB.get(i).get("sensorCategory") + " " + DB.get(i).get("sensorName"));
			int monitorTimes = time / Integer.parseInt(DB.get(i).get("patientPeriod")) + 1;
			for(int j = 0; j < monitorTimes; j++) {
				System.out.println(DB.get(i).get("record" + Integer.toString(j)));
			}
		}
	}
}