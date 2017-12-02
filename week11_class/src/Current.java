import java.util.ArrayList;

public class Current implements Display {
    private ArrayList<Data> dataArrayList = new ArrayList<>();

    @Override
    public void update(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
        this.display();
    }
    private void display() {
        int end = dataArrayList.size() - 1;
        System.out.printf("Temperature %.1f\n", dataArrayList.get(end).getTemperature());
        System.out.printf("Humidity %.1f\n", dataArrayList.get(end).getHumidity());
        System.out.printf("Pressure %.1f\n", dataArrayList.get(end).getPressure());
    }

    public String getType() {
        return "Current";
    }
}
