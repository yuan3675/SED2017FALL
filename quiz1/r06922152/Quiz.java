import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Quiz {
	public static void main(String[] args) throws Exception{
		File dataFile = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));
		FactorMonitor fMonitor = new FactorMonitor();
		
		int patientCount = 0;
		String line = reader.readLine();
		int monitor_time = Integer.parseInt(line);
		while(line != null) {
			String[] info = line.split(" ");
			if (info[0].compareTo("patient") == 0) {		//see if there is a new patient
				Patient p  = new Patient(info[1], Integer.parseInt(info[2]));	
				fMonitor.addPatient(p);	
			}
			else {
				Sensor[] sensor;
				if (info[0].compareTo("PulseSensor") == 0) {
					PulseRateRange prr = new PulseRateRange(Double.parseDouble(info[4]), Double.parseDouble(info[3]));
					PulseSensor ps = new PulseSensor(info[1], info[2]);
					Patient p = fMonitor.getCurrentPatient();
					p.attachSensor(ps, prr);	
				}
				else if (info[0].compareTo("BloodPressureSensor") == 0) {
					BloodPressureRange bpr = new BloodPressureRange(Double.parseDouble(info[4]), Double.parseDouble(info[3]));
					BloodPressureSensor bps = new BloodPressureSensor(info[1], info[2]);
					Patient p = fMonitor.getCurrentPatient();
					p.attachSensor(bps, bpr);
				}
				else if (info[0].compareTo("TemperatureSensor") == 0){
					TemperatureRange tr = new TemperatureRange(Double.parseDouble(info[4]), Double.parseDouble(info[3]));
					TemperatureSensor ts = new TemperatureSensor(info[1], info[2]);
					Patient p = fMonitor.getCurrentPatient();
					p.attachSensor(ts, tr);
				}	
			}
			/*for(int i =0; i < info.length; i++){
				System.out.println(i);
				System.out.println(info[i]);
			}*/
			line = reader.readLine();
		}
		reader.close();
		fMonitor.monitor(monitor_time);	
		fMonitor.disPlayResult();
	}
}