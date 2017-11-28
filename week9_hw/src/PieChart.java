import java.text.DecimalFormat;
import java.util.ArrayList;

public class PieChart implements Presentation{
    @Override
    public void depict(ArrayList<ApplicationData> applicationDataList) {
        double sum = 0;
        for (int i = 0; i < applicationDataList.size(); i++) {
            ApplicationData applicationData = applicationDataList.get(i);
            sum = sum + applicationData.getValue();
        }
        for (int i = 0; i < applicationDataList.size(); i++) {
            ApplicationData applicationData = applicationDataList.get(i);
            String item = applicationData.getName();
            int value = applicationData.getValue();
            double percentage = 100 * (double) value / sum;
            System.out.printf("%s %.1f%%\n", item, percentage);
        }
    }
}
