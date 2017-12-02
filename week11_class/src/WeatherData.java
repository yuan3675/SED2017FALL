import java.util.ArrayList;

public class WeatherData {
    private ArrayList<Data> dataArrayList = new ArrayList<>();
    private ArrayList<Display> displayArrayList = new ArrayList<>();

    public void notifyDisplay() {
        if (displayArrayList.size() != 0) {
            for (Display display : displayArrayList) {
                display.update(dataArrayList);
            }
        }
    }
    public void attach(Display display) {
        displayArrayList.add(display);
    }
    public void detach(String type) {
        for (Display display : displayArrayList) {
            if (display.getType().equals(type)) {
                displayArrayList.remove(display);
                break;
            }
        }
    }
    public void addData(Data data) {
        dataArrayList.add(data);
    }

    public ArrayList<Data> getDataArrayList() {
        return dataArrayList;
    }

    public ArrayList<Display> getDisplayArrayList() {
        return displayArrayList;
    }
}
