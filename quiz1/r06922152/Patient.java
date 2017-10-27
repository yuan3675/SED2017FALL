import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Patient {
	private String patientName;
	private ArrayList<Sensor> sensor = new ArrayList<Sensor>();
	private Map<Sensor, SafeRange> safety = new HashMap<Sensor, SafeRange>();
	private int frequency;
	private int sensorCount = 0;
	
	public Patient(String name, int feq) {
		this.patientName = name;
		this.frequency = feq;
	}
	
	public void attachSensor(Sensor sen, SafeRange sr) {
		this.safety.put(sen, sr);
		this.sensor.add(sen);
		this.sensorCount ++;
	}
	
	public String getPatientName(){
		return this.patientName;
	}
	
	public int getFrequency(){
		return this.frequency;
	}
	
	public ArrayList<Sensor> getSensor(){
		return this.sensor;
	}
	
	public Map<Sensor, SafeRange> getSafety(){
		return this.safety;
	}
}