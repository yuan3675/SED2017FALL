import java.util.ArrayList;
import java.util.Map;

public class Monthly_Report implements  Report {
    @Override
    public void display(Department d){
        int month = d.getDisplayMonth();
        Map<Integer, ArrayList> monthProduct = d.getMonthProduct();
        ArrayList a = monthProduct.get(month);
        for(int i = 0; i < a.size(); i=i+2){
            System.out.println(a.get(i) + " " + a.get(i+1));
        }
    }
}
