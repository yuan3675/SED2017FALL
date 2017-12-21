import java.util.ArrayList;

public class ListObject {
    private ArrayList<StringObject> stringObjectArrayList = new ArrayList<>();
    public int length = 0;

    public ArrayList<StringObject> getStringObjectArrayList() {
        return stringObjectArrayList;
    }
    public void addLength() {
        length ++;
    }

    public String get(int index) {
        return stringObjectArrayList.get(index).getContext();
    }

}
