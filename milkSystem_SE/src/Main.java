import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Company company = new Company();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            String command = info[0];

            if (command.equals("addHousehold")) {
                Household household = new Household(info[2], info[1]);
                company.addHouseholds(household);
            }
            else if (command.equals("setMilk")) {
                Brand brand = new Brand(info[1]);
                company.setBrands(brand);
            }
            else if (command.equals("setHousehold")) {
                company.setHouseholds(info[1], info[2]);
            }
            else if (command.equals("setVacation")) {
                Vacation vacation = new Vacation(Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                ArrayList<Household> householdArrayList = company.getHouseholds();
                for (Household household : householdArrayList) {
                    if (household.getName().equals(info[1])) {
                        company.setVacationMap(household, vacation);
                    }
                }
            }
            else if (command.equals("setOrder")) {
                ArrayList<Household> householdArrayList = company.getHouseholds();
                for (Household household : householdArrayList) {
                    for (Brand brand : company.getBrands()) {
                        if (brand.getName().equals(info[2])) {
                            if (household.getName().equals(info[1])) {
                                boolean find = false;
                                for (Order order : company.getOrders()) {
                                    if (order.getHousehold().equals(household) && order.getMonth() == Integer.parseInt(info[4])) {
                                        Milk milk = order.getMilk();
                                        Brand milkbrand = milk.getBrand();
                                        if (brand.equals(milkbrand)) {
                                            milk.setLiter(Integer.parseInt(info[3]));
                                            find = true;
                                            break;
                                        }
                                    }
                                }
                                if (!find) {
                                    Milk milk = new Milk(brand, Integer.parseInt(info[3]));
                                    Order order = new Order(household, milk, Integer.parseInt(info[4]));
                                    company.setOrders(order);
                                }
                            }
                        }
                    }
                }
            }
            else if (command.equals("Date")) {
                int month = Integer.parseInt(info[1]);
                int day = Integer.parseInt(info[2]);

                Map<String, Integer> total = company.printDailyList(month, day);
                company.printSummary(total);
                if (day == 30) {
                    company.printBill(month, day);
                }
            }
        }

    }
}
