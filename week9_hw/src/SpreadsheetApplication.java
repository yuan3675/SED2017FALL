import java.util.ArrayList;

public class SpreadsheetApplication {
    private ArrayList<ApplicationData> applicationDataArrayList = new ArrayList<>();
    private ArrayList<Chart> chartArrayList = new ArrayList<>();

    public ArrayList<ApplicationData> getApplicationDataArrayList() {
        return applicationDataArrayList;
    }

    public void setApplicationDataArrayList(ApplicationData applicationData) {
        this.applicationDataArrayList.add(applicationData);
    }

    public ArrayList<Chart> getChartArrayList() {
        return chartArrayList;
    }

    public void attach(Chart chart) {
        this.chartArrayList.add(chart);
    }

    public void detach() {

    }

    public void change(String name, int value) {
        boolean find = false;
        for (ApplicationData applicationData : this.applicationDataArrayList) {
            if (applicationData.getName().equals(name)) {
                find = true;
                applicationData.setValue(value);
            }
        }
        if (!find) {
            ApplicationData applicationData = new ApplicationData(name, value);
            this.applicationDataArrayList.add(applicationData);
        }
        for (Chart chart : chartArrayList) {
            chart.update(name, value);
            chart.display();
        }
    }
}
