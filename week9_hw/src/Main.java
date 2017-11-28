import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        ArrayList<ApplicationData> applicationDataArrayList = new ArrayList<ApplicationData>();
        for (int i = 1; i <= 10; i++) {
            ApplicationData applicationData = new ApplicationData();
            applicationData.setName("yuan" + i);
            applicationData.setValue(i);
            applicationDataArrayList.add(applicationData);
        }
        Presentation presentation = new PieChart();
        presentation.depict(applicationDataArrayList);
    }
}

