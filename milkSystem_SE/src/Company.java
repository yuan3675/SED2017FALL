import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Company {
    private ArrayList<Brand> brands = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private Map<Household, ArrayList<BillingDetail>> billingDetails = new HashMap<>();
    private Map<Household, ArrayList<Vacation>> vacationMap = new HashMap<>();
    private ArrayList<Household> households = new ArrayList<>();

    public ArrayList<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Brand brand) {
        this.brands.add(brand);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(Order order) {
        this.orders.add(order);
    }

    public Map<Household, ArrayList<BillingDetail>> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Household household, ArrayList<BillingDetail> billingDetail) {
        this.billingDetails.put(household, billingDetail);
    }

    public Map<Household, ArrayList<Vacation>> getVacationMap() {
        return vacationMap;
    }

    public void setVacationMap(Household household, Vacation vacation) {
        ArrayList<Vacation> vacationArrayList = vacationMap.get(household);
        boolean find = false;
        for (Vacation vacation1 : vacationArrayList) {
            if (vacation1.getMonth() == vacation.getMonth() && vacation.getDay() == vacation1.getDay()) {
                find = true;
            }
        }
        if (!find) {
            vacationArrayList.add(vacation);
        }
    }

    public ArrayList<Household> getHouseholds() {
        return households;
    }

    public void addHouseholds(Household household) {
        this.households.add(household);
        ArrayList<Vacation> vacations = new ArrayList<>();
        ArrayList<BillingDetail> billingDetails1 = new ArrayList<>();
        vacationMap.put(household, vacations);
        billingDetails.put(household, billingDetails1);
    }

    public void setHouseholds(String name, String address) {
        for (Household household : households) {
            if (household.getName().equals(name)) {
                household.setAddress(address);
            }
        }
    }

    public Map<String, Integer> printDailyList(int month, int day) {
        System.out.println("List:");
        Map<String, Integer> total = new HashMap<>();
        for(Household household : households) {
            System.out.println(household.getName() + " " + household.getAddress());
            ArrayList<Vacation> vacationArrayList = vacationMap.get(household);
            boolean isVacation = false;
            for (Vacation vacation : vacationArrayList) {
                if(vacation.getMonth() == month && vacation.getDay() == day) {
                    isVacation = true;
                }
            }
            if (!isVacation) {
                for (Order order : orders) {
                    if (order.getHousehold().equals(household) && order.getMonth() == month) {
                        Milk milk = order.getMilk();
                        Brand brand = milk.getBrand();
                        System.out.println(brand.getName() + " " + milk.getLiter());
                        if(total.get(brand.getName()) != null) {
                            int num = total.get(brand.getName());
                            num = num + milk.getLiter();
                            total.put(brand.getName(), num);
                        }
                        else {
                            total.put(brand.getName(), milk.getLiter());
                        }
                    }
                }
            }
        }

        return total;
    }
    public void printSummary(Map<String, Integer> total){
        System.out.println("Summary:");
        for(Brand brand : brands) {
            if(total.get(brand.getName()) == null) {
                System.out.println(brand.getName() + " " + 0);
            }
            else {
                System.out.println(brand.getName() + " " + total.get(brand.getName()));
            }
        }
    }
    public void printBill(int month, int day) {
        System.out.println("Bill:");
        for (Household household : households) {
            Map<String, Integer> total = new HashMap<>();
            System.out.println(household.getName() + " " + household.getAddress());
            for (Order order : orders) {
                if (order.getHousehold().equals(household) && order.getMonth() == month) {
                    Milk milk = order.getMilk();
                    Brand brand = milk.getBrand();
                    total.put(brand.getName(), milk.getLiter());
                }
            }
            ArrayList<Vacation> vacationArrayList = vacationMap.get(household);
            int vacationAmount = 0;
            for (Vacation vacation : vacationArrayList) {
                if (vacation.getMonth() == month) {
                    vacationAmount ++;
                }
            }
           for (Brand brand : brands) {
                if (total.get(brand.getName()) == null) {
                    System.out.println(brand.getName() + " " + 0);
                }
                else {
                    int value = total.get(brand.getName());
                    int total_value = value * (30 - vacationAmount);
                    System.out.println(brand.getName() + " " + total_value);
                }
           }
        }
    }
}
