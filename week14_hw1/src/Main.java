import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        VacationPlanner vacationPlanner = new VacationPlanner();
        Map<String, String> plan = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            if (line.equals("Normal")) {
                if(plan.get("type") != null) {
                    vacationPlanner.constructPlan(plan);
                    plan = new HashMap<>();
                }
                plan.put("type", "Normal");
            }
            else if (line.equals("Backpacking")) {
                if(plan.get("type") != null) {
                    vacationPlanner.constructPlan(plan);
                    plan = new HashMap<>();
                }
                plan.put("type", "Backpacking");
            }
            else {
                String[] info = line.split(" ");
                if (info.length == 2) {
                    plan.put(info[0], info[1]);
                }
            }
        }
        if(plan.get("type") != null) {
            vacationPlanner.constructPlan(plan);
        }
        vacationPlanner.printVacations();
    }
}
