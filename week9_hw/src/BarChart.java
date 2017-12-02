import java.util.ArrayList;

public class BarChart implements Chart {
    private SpreadsheetApplication spreadsheetApplication;

    public BarChart(SpreadsheetApplication spreadsheetApplication) {
        this.spreadsheetApplication = spreadsheetApplication;
    }

    @Override
    public String getType() {
        return("BarChart");
    }

    @Override
    public void update(String name, int value) {
        boolean find = false;
        ArrayList<ApplicationData> applicationDataArrayList = this.spreadsheetApplication.getApplicationDataArrayList();
        for (ApplicationData applicationData : applicationDataArrayList) {
            if (applicationData.getName().equals(name)) {
                find = true;
                applicationData.setValue(value);
            }
        }
        if (!find) {
            ApplicationData applicationData = new ApplicationData(name, value);
            this.spreadsheetApplication.setApplicationDataArrayList(applicationData);
        }
    }

    @Override
    public void change(String name, int value) {
        System.out.println("BarChart change " + name + " " + value + ".");
        boolean find = false;
        ArrayList<ApplicationData> applicationDataArrayList = this.spreadsheetApplication.getApplicationDataArrayList();
        for (ApplicationData applicationData : applicationDataArrayList) {
            if (applicationData.getName().equals(name)) {
                find = true;
                applicationData.setValue(value);
            }
        }
        if (!find) {
            ApplicationData applicationData = new ApplicationData(name, value);
            this.spreadsheetApplication.setApplicationDataArrayList(applicationData);
        }
        this.spreadsheetApplication.change(name, value);
    }

    @Override
    public void display() {
        ArrayList<ApplicationData> applicationDataArrayList = this.spreadsheetApplication.getApplicationDataArrayList();
        for (ApplicationData applicationData : applicationDataArrayList) {
            int value = applicationData.getValue();
            for (int i=0; i < value; i++) {
                System.out.printf("=");
            }
            System.out.printf(" %s\n", applicationData.getName());
        }
    }
}
