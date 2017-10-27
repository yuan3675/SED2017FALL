import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public  static void main(String[] args)throws Exception{
        ArrayList<Department> Departments = new ArrayList<Department>();
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        while(line != null) {
            String[] info = line.split(" ");
            if (info[0].equals("department")) {
                boolean check = false;
                int label = 0;
                for(int i = 0; i < Departments.size(); i++){
                    if(Departments.get(i).getName().equals(info[1])){
                        check = true;
                        label = i;
                    }
                }
                if (!check) {
                    Department dep = new Department();
                    dep.setName(info[1]);
                    int month = Integer.parseInt(info[2]);
                    dep.setMonth(month);
                    ArrayList<String> products = new ArrayList<>();
                    for(int j = 3; j < info.length; j++){
                        String[] product = info[j].split(",");
                        products.add(product[0]);
                        products.add(product[1]);
                    }
                    dep.setMonth_product(month, products);
                    Departments.add(dep);
                }
                else {
                    Department dep = Departments.get(label);
                    int month = Integer.parseInt(info[2]);
                    dep.setMonth(month);
                    ArrayList<String> products = new ArrayList<>();
                    for(int j = 3; j < info.length; j++){
                        String[] product = info[j].split(",");
                        products.add(product[0]);
                        products.add(product[1]);
                    }
                    dep.setMonth_product(month, products);
                }
            }
            else if (info[0].equals("select")) {
                for(int i =0; i < Departments.size(); i++){
                    if(info[1].equals(Departments.get(i).getName())){
                        Department d = Departments.get(i);
                        boolean check = d.displayMonthlyReport(Integer.parseInt(info[2]));
                        if (check){
                            System.out.println("display YTDSalesChart for " + info[1]);
                            d.displayYTD();
                        }
                    }
                }
            }
            line = reader.readLine();
        }
    }
}
