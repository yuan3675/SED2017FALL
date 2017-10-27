import java.util.ArrayList;
import java.util.Map;

public class YTD_Sales_Chart implements Report {
    @Override
    public void display(Department d) {
        Map<Integer, ArrayList> monthProduct = d.getMonthProduct();
        ArrayList<Integer> month = d.getMonth();
        for(int i=0; i < month.size(); i++){
            int m = month.get(i);
            ArrayList<String> product = monthProduct.get(m);
            int sum = 0;
            for(int j=1; j < product.size(); j=j+2){
                sum = sum + Integer.parseInt(product.get(j));
            }
            System.out.println("month " + m + " price " + sum);
        }
    }
}
