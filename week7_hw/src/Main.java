import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        Online_Shopping_Site oss = new Online_Shopping_Site();
        ArrayList<Company> companyList = new ArrayList<>();

        while(line != null) {
            String[] info = line.split(" ");
            if (info[0].equals("company")) {
                Company c = new Company();
                c.setCompanyType(info[1]);
                if (info[2].equals("CSV") || info[2].equals("XML") || info[2].equals("Object")) {
                    c.setCategory(info[2]);
                }
                else {
                    System.out.println("Wrong company category!");
                }
                companyList.add(c);
            }
            else if (info[0].equals("order")) {
                oss.createOrder(companyList, Integer.parseInt(info[1]), info[2], info[3]);
            }
            else if (info[0].equals("transmit")) {
                oss.orderTransmit(companyList, Integer.parseInt(info[1]));
            }
            else {
                System.out.println("Oops! Something went wrong.");
            }
            line = reader.readLine();
        }
    }
}
