import java.util.ArrayList;

public class Forecast implements Display {
    private ArrayList<Data> dataArrayList = new ArrayList<>();
    @Override
    public void update(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
        this.display();
    }
    private void display() {
        int end = dataArrayList.size() - 1;
        double humidity = dataArrayList.get(end).getHumidity();
        if (humidity > 0.8) {
            System.out.println("Forecast rain.");
        }
        else if (humidity < 0.2) {
            System.out.println("Forecast sunny.");
        }
        else {
            System.out.println("Forecast cloudy.");
        }
    }

    @Override
    public String getType() {
        return "Forecast";
    }
}
