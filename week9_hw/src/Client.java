import java.util.ArrayList;

public class Client {
    private ArrayList<Chart> chartArrayList = new ArrayList<>();

    public void setChart(Chart chart) {
        this.chartArrayList.add(chart);
    }
    public void change(String[] info) {
        for (Chart chart : this.chartArrayList) {
            if (chart.getType().equals(info[1])) {
                chart.change(info[2], Integer.parseInt(info[3]));
            }
        }
    }
}
