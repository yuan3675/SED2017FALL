import java.util.ArrayList;

public class Spreadsheet implements Chart {
    private  SpreadsheetApplication spreadsheetApplication;

    public Spreadsheet(SpreadsheetApplication spreadsheetApplication) {
        this.spreadsheetApplication = spreadsheetApplication;
    }

    @Override
    public String getType() {
        return("Spreadsheet");
    }

    @Override
    public void display() {
        ArrayList<ApplicationData> applicationDataArrayList = this.spreadsheetApplication.getApplicationDataArrayList();
        for (ApplicationData applicationData : applicationDataArrayList) {
            System.out.println(applicationData.getName() + " " + applicationData.getValue());
        }
    }

    @Override
    public void change(String name, int value) {
        System.out.println("Spreadsheet change " + name + " " + value + ".");
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
