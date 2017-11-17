import java.util.ArrayList;

public class BookingService {
    private ArrayList<Performance> performances = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private int reservationNumber = 0;

    public void setPerformances(int date, int hour, int numSeat) {
        Performance performance = new Performance();
        int[] startTime = new int[2];
        startTime[0] = date;
        startTime[1] = hour;
        performance.setAvailableSeatNum(numSeat);
        performance.setStartTime(startTime);
        performance.setAvailableSeatNum(numSeat);
        performances.add(performance);
    }
    public void book(int[] timeStamp, int date, String name, String phone, int numAttendenee){
        int startHour = 0;
        for (int i=0; i < performances.size(); i++) {
            Performance performance = performances.get(i);
            int[] startTime = performance.getStartTime();
            if (startTime[0] == date) {
                startHour = startTime[1];
                break;
            }
        }
        this.reservationNumber ++;
        Reservation reservation = new Reservation();
        reservation.setReservationNum(reservationNumber);
        reservation.setCustomerName(name);
        reservation.setNumAttendenees(numAttendenee);
        reservation.setPhoneNumber(phone);
        reservation.setTimeStamp(timeStamp);
        reservation.setTickets(numAttendenee, date, startHour);
        reservations.add(reservation);
        for (int i=0; i<performances.size(); i++) {
            Performance performance = performances.get(i);
            int[] time = performance.getStartTime();
            if(time[0] == date) {
                assign(i, -1*numAttendenee);
                break;
            }
        }
        System.out.println("Reserve #" + this.reservationNumber + ". name: " + name + ", tickets: " + numAttendenee);
    }

    public void cancel(int[] timeStamp, int reservationNumber, String name, String phone) {
        for (int i=0;i<reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            if (reservation.getReservationNum() == reservationNumber) {
                if (!reservation.getCustomerName().equals(name) || !reservation.getPhoneNumber().equals(phone)) {
                    System.out.println("Cancel fail. Identification check fail.");
                    return;
                }
                if(reservation.isCanceled()) {
                    System.out.println("Cancel fail. Reservation already cancelled.");
                    return;
                }
                if(reservation.isPickedUp()) {
                    System.out.println("Cancel fail. Reservation already picked up.");
                    return;
                }
                reservation.setCanceled(true);
                assign(i, reservation.getNumAttendenees());
                System.out.println("Cancel #" + reservationNumber + ". name: " + reservation.getCustomerName() + ", tickets: " + reservation.getNumAttendenees());
                return;
            }
        }
        System.out.println("Cancel fail. No such reservation.");
    }
    public void pickUp(int[] timeStamp, int reservationNumber, String name, String phone) {
            for (int i = 0; i < reservations.size(); i++) {
                Reservation reservation = reservations.get(i);
                if (reservation.getReservationNum() == reservationNumber) {
                    if (!reservation.getCustomerName().equals(name) || !reservation.getPhoneNumber().equals(phone)) {
                        System.out.println("Pickup fail. Identification check fail.");
                        return;
                    }
                    if (reservation.isCanceled()) {
                        System.out.println("Pickup fail. Reservation already cancelled.");
                        return;
                    }
                    if (reservation.isPickedUp()) {
                        System.out.println("Pickup fail. Reservation already picked up.");
                        return;
                    }
                    reservation.setPickedUp(true);
                    System.out.println("Pickup #" + reservationNumber + ". name: " + reservation.getCustomerName() + ", tickets: " + reservation.getNumAttendenees());
                    return;
                }
            }
            System.out.println("Pickup fail. No such reservation.");
    }
    private void assign(int index, int num) {
        Performance performance = performances.get(index);
        int availableSeatNum = performance.getAvailableSeatNum();
        availableSeatNum = availableSeatNum + num;
        performance.setAvailableSeatNum(availableSeatNum);
    }

    public ArrayList<Performance> getPerformances() {
        return performances;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    public void checkTime(int[] time) {
        for(int i=0; i<reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            ArrayList<Ticket> tickets = reservation.getTickets();
            int[] startTime = tickets.get(0).getDate();
            if(time[0] > startTime[0]) {
                if(!reservation.isCanceled() && !reservation.isPickedUp()) {
                    reservation.setCanceled(true);
                    System.out.println("Cancel #" + reservation.getReservationNum() + ". name: " + reservation.getCustomerName() + ", tickets: " + reservation.getNumAttendenees());
                }
            }
            else if (time[1]+2 >= startTime[1]) {
                if(!reservation.isCanceled() && !reservation.isPickedUp()) {
                    reservation.setCanceled(true);
                    System.out.println("Cancel #" + reservation.getReservationNum() + ". name: " + reservation.getCustomerName() + ", tickets: " + reservation.getNumAttendenees());
                }
            }
            if (time[0] == startTime[0] && time[1] == startTime[1]) {
                if((reservation.isCanceled() || !reservation.isPickedUp()) && reservation.isExist()) {
                    reservation.setExist(true);
                    System.out.println("Clear #" + reservation.getReservationNum() + ". name: " + reservation.getCustomerName() + ", tickets: " + reservation.getNumAttendenees());
                }
            }
        }
    }
}
