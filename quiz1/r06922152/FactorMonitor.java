import java.util.Map;
import java.util.ArrayList;

public class FactorMonitor {
	private ArrayList<Patient> patient = new ArrayList<Patient>();
	private int patientCount = 0;
	
	public void addPatient(Patient p) {
		patient.add(p);
		patientCount ++;
	}
	
	public Patient getCurrentPatient() {
		return patient.get(patientCount-1);
	}
	
	public void monitor(int time) throws Exception{
		for(int k = 0; k <= time; k ++){
			for(int i = 0; i < patient.size(); i++){
				if(k % patient.get(i).getFrequency() == 0){
					Map<Sensor, SafeRange> safety = patient.get(i).getSafety();
					ArrayList<Sensor> sensor = patient.get(i).getSensor();
					for(int j = 0; j < sensor.size(); j++){
						double factor = sensor.get(j).read(k / patient.get(i).getFrequency()+1);
						if(factor == -1){
							System.out.println("[" + k + "] " + sensor.get(j).getSensorName() + " falls");
						}
						else if (factor < safety.get(sensor.get(j)).getLowerBound() || factor > safety.get(sensor.get(j)).getUpperBound()){
							String message = "[" + k + "] " + patient.get(i).getPatientName() + " is in danger! Cause: " + sensor.get(j).getSensorName() + " " + factor;
							this.displayAlarm(message);
						}
						this.saveTODatabase(sensor.get(j),k,factor);
					}
				}
			}				
		}
	}
	private void saveTODatabase(Sensor sensor, int time, double factor) {
		sensor.setMonitorTime(time);
		sensor.setMonitorValue(factor);
	}
	private void displayAlarm (String message) {
		System.out.println(message);
	}	
	
	public void disPlayResult(){
		for(int i =0; i < patient.size(); i++){
			Patient p = patient.get(i);
			System.out.println("patient " + p.getPatientName());
			for(int j = 0; j < p.getSensor().size(); j++){
				Sensor s = p.getSensor().get(j);
				System.out.println(s.getSensorType() + " " + s.getSensorName());
				for(int k = 0; k < s.getMonitorTime().size(); k++){
					System.out.println("["+s.getMonitorTime().get(k)+"] " + s.getMonitorValue().get(k));
				}
			}
		}
	}
}