import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Department {
    private int displayMonth;
    private String name;
    private ArrayList<String> productName = new ArrayList<>();
    private ArrayList<Integer> month = new ArrayList<>();
    private Map<Integer, ArrayList> month_product = new HashMap<Integer, ArrayList>();

    public void setName(String n){
        this.name = n;
    }
    public void setMonth_product(int m, ArrayList a){
        this.month_product.put(m, a);
    }
    public void setProductName(String n){
        int check = 0;
        for(int i=0; i < productName.size(); i++) {
            if (productName.get(i) == n) check = 1;
        }
        if (check == 0) productName.add(n);
    }
    public void setMonth(int n){
        int check = 0;
        for(int i=0; i < month.size(); i++) {
            if (month.get(i) == n) check = 1;
        }
        if (check == 0) month.add(n);
    }
    public String getName(){
        return this.name;
    }
    public int getDisplayMonth(){
        return this.displayMonth;
    }

    public Map getMonthProduct(){
        return this.month_product;
    }

    public ArrayList<Integer> getMonth(){
        return this.month;
    }
    public boolean displayMonthlyReport(int m){
        Monthly_Report mr = new Monthly_Report();
        if(month_product.get(m) == null){
            System.out.println("no data in selected month!");
            return  false;
        }
        System.out.println("display MonthlyReport for " + name + " month " + m);
        displayMonth = m;
        mr.display(this);
        return true;
    }

    public void displayYTD(){
        YTD_Sales_Chart sc = new YTD_Sales_Chart();
        sc.display(this);
    }
}
