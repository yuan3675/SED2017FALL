import java.util.ArrayList;

public class Statistic implements Display {
    private ArrayList<Data> dataArrayList = new ArrayList<>();
    @Override
    public void update(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
        this.display();
    }
    private void display() {
        System.out.print("Temperature");
        for (Data data : dataArrayList) {
            System.out.printf(" %.1f", data.getTemperature());
        }
        System.out.printf("\n");
        System.out.print("Humidity");
        for (Data data : dataArrayList) {
            System.out.printf(" %.1f", data.getHumidity());
        }
        System.out.printf("\n");
        System.out.print("Pressure");
        for (Data data : dataArrayList) {
            System.out.printf(" %.1f", data.getPressure());
        }
        System.out.printf("\n");
    }

    @Override
    public String getType() {
        return "Statistics";
    }
}
