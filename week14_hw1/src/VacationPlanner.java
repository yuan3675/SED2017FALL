import java.util.ArrayList;
import java.util.Map;

public class VacationPlanner {
    private ArrayList<Vacation> vacations = new ArrayList<>();

    public void constructPlan(Map<String, String> plan){
        if(plan.containsKey("type")) {
            VacationBuilder vacationBuilder = null;
            if (plan.get("type").equals("Normal")) {
                vacationBuilder = new NormalVacationBuilder();
            }
            else {
                vacationBuilder = new BackpackingVacationBuilder();
            }
            if (plan.containsKey("Day")) {
                String day = plan.get("Day");
                vacationBuilder.chooseDay(day);
            }
            if (plan.containsKey("Hotel")) {
                String hotel = plan.get("Hotel");
                vacationBuilder.chooseHotel(hotel);
            }
            if (plan.containsKey("SpecialEvent")) {
                String SpecialEvent = plan.get("SpecialEvent");
                vacationBuilder.chooseSpecialEvent(SpecialEvent);
            }
            if (plan.containsKey("Reservation")) {
                String Reservation = plan.get("Reservation");
                vacationBuilder.chooseReservation(Reservation);
            }
            if (plan.containsKey("Tickets")) {
                String Tickets = plan.get("Tickets");
                vacationBuilder.chooseTicket(Tickets);
            }
            vacations.add(vacationBuilder.getVacation());
        }
    }
    public void printVacations() {
        for (Vacation vacation : vacations) {
            if (vacation instanceof NormalVacation) {
                System.out.println("NormalVacation");
                System.out.println("Day:" + ((NormalVacation) vacation).getDay());
                System.out.println("Hotel:" + ((NormalVacation) vacation).getHotel());
                System.out.println("Reservation:" + ((NormalVacation) vacation).getReservation());
                System.out.println("SpecialEvent:" + ((NormalVacation) vacation).getSpecialEvent());
                System.out.println("Tickets:" + ((NormalVacation) vacation).getTicket());
            }
            else if (vacation instanceof BackpackVacation) {
                System.out.println("BackpackingVacation");
                System.out.println("Day:" + ((BackpackVacation) vacation).getDay());
                System.out.println("Hotel:" + ((BackpackVacation) vacation).getHotel());
                System.out.println("Reservation:" + ((BackpackVacation) vacation).getReservation());
                System.out.println("SpecialEvent:" + ((BackpackVacation) vacation).getSpecialEvent());
                System.out.println("Tickets:" + ((BackpackVacation) vacation).getTicket());
            }
        }
    }
}
