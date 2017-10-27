import java.util.ArrayList;
public abstract class Sensor {
	private String sensorName;
	private String datasetPath;
	private ArrayList<Integer> monitor_time = new ArrayList<Integer>();
	private ArrayList<Double> monitor_value = new ArrayList<Double>();
	
	/*public Sensor(String name, String dataset) {
		this.sensorName = name;
		this.datasetPath = dataset;
	}*/
	
	public abstract double read(int times) throws Exception;
	public abstract String getSensorType();

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