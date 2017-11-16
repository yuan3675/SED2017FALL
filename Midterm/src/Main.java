import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        int[] timeStamp = new int[2];
        ArrayList<Customer> customers = new ArrayList<>();
        BookingService bookingService = new BookingService();

        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");

            if (info[0].equals("performance")) {
                bookingService.setPerformances(Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]));
            }
            else if (info[0].equals("book")) {
                Staff staff = new CustomerServiceStaff();
                boolean check = staff.check(info, bookingService);
                if (check == true) {
                    Customer thisCustomer = null;
                    for (int i = 0; i < customers.size(); i++) {
                        Customer customer = customers.get(i);
                        if (info[3].equals(customer.getName()) && info[4].equals(customer.getPhone())) {
                            thisCustomer = customer;
                            break;
                        }
                    }
                    if (thisCustomer == null) {
                        thisCustomer = new Customer();
                        thisCustomer.setName(info[3]);
                        thisCustomer.setPhone(info[4]);
                        customers.add(thisCustomer);
                    }
                }
                else {
                    System.out.println("Book fail. Not enough seats in requested performance.");
                }
            }
            else if (info[0].equals("cancel")) {
                Staff staff = new CustomerServiceStaff();
                staff.check(info, bookingService);
            }
            else if (info[0].equals("pickup")) {
                Staff staff = new BoxOfficeStaff();
                staff.check(info, bookingService);
            }
            else if (info[0].equals("time")) {
                String[] time = info[1].split(",");
                timeStamp[0] = Integer.parseInt(time[0]);
                timeStamp[1] = Integer.parseInt(time[1]);
                Staff staff = new BoxOfficeStaff();
                staff.check(info, bookingService);
            }
            else {
                System.out.println("Command error!");
            }
        }
    }
}
