import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BloodPressureSensor extends Sensor {
	private String sensorName;
	private String datasetPath;
	private ArrayList<Integer> monitor_time = new ArrayList<Integer>();
	private ArrayList<Double> monitor_value = new ArrayList<Double>();
	
	public BloodPressureSensor(String name, String dataset) {
		this.sensorName = name;
		this.datasetPath = dataset;
	}
	
	public double read(int times) throws Exception{
		File dataFile = new File(this.datasetPath);
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		String line = "";
		for (int i = 0; i < times; i++){
			line = reader.readLine();
		}
		reader.close();
		if(line == null)line = "-1";
		double value = Double.parseDouble(line);
		return value;
	}
	
	public String getSensorType(){
		return "BloodPressureSensor";
	}
	
	public String getSensorName() {
		return this.sensorName;
	}
	
	public String getDatasetPath() {
		return this.datasetPath;
	}
	
	public void setMonitorTime(int time){
		this.monitor_time.add(time);
	}
	
	public void setMonitorValue(double value){
		this.monitor_value.add(value);
	}
	
	public ArrayList<Integer> getMonitorTime(){
		return this.monitor_time;
	}
	
	public ArrayList<Double> getMonitorValue(){
		return this.monitor_value;
	}
}