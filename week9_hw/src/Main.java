import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        SpreadsheetApplication spreadsheetApplication = new SpreadsheetApplication();
        Client client = new Client();

        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            String command = info[0];

            if (command.equals("data")) {
                ApplicationData applicationData = new ApplicationData(info[1], Integer.parseInt(info[2]));
                spreadsheetApplication.setApplicationDataArrayList(applicationData);
            }
            else if (command.equals("addChart")) {
                if (info[1].equals("Spreadsheet")) {
                    Spreadsheet spreadsheet = new Spreadsheet(spreadsheetApplication);
                    spreadsheetApplication.attach(spreadsheet);
                    client.setChart(spreadsheet);
                }
                else if (info[1].equals("BarChart")) {
                    BarChart barChart = new BarChart(spreadsheetApplication);
                    spreadsheetApplication.attach(barChart);
                    client.setChart(barChart);
                }
                else {
                    PieChart pieChart = new PieChart(spreadsheetApplication);
                    spreadsheetApplication.attach(pieChart);
                    client.setChart(pieChart);
                }
            }
            else if (command.equals("change")) {
                client.change(info);
            }
            else {
                System.out.println("No such command!");
            }
        }
    }
}
