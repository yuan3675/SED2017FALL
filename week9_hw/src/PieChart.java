import java.util.ArrayList;

public class PieChart implements Chart {
    private  SpreadsheetApplication spreadsheetApplication;

    public PieChart(SpreadsheetApplication spreadsheetApplication) {
        this.spreadsheetApplication = spreadsheetApplication;
    }

    @Override
    public String getType() {
        return("PieChart");
    }

    @Override
    public void display() {
        ArrayList<ApplicationData> applicationDataArrayList = this.spreadsheetApplication.getApplicationDataArrayList();
        double sum = 0.0;
        for (ApplicationData applicationData : applicationDataArrayList) {
            sum = sum + applicationData.getValue();
        }
        for (ApplicationData applicationData : applicationDataArrayList) {
            double percentage = 100 * applicationData.getValue() / sum;
            System.out.printf("%s %.1f%%\n", applicationData.getName(), percentage);
        }
    }

    @Override
    public void change(String name, int value) {
        System.out.println("PieChart change " + name + " " +value + ".");
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
}
