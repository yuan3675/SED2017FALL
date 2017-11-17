import java.util.ArrayList;

public class Reservation {
    private int reservationNum;
    private String customerName;
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private int[] timeStamp = new int[2];
    private String phoneNumber;
    private int numAttendenees;
    private boolean isCanceled = false;
    private boolean isPickedUp = false;
    private boolean isExist = true;


    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    public void setReservationNum(int reservationNum) {
        this.reservationNum = reservationNum;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setTimeStamp(int[] time) {
        this.timeStamp = time;
    }
    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public void setNumAttendenees(int numAttendenees) {
        this.numAttendenees = numAttendenees;
    }

    public void setTickets(int num, int date, int hour) {
        for(int i=0; i<num; i++) {
            Ticket ticket = new Ticket();
            int[] timeStamp = new int[2];
            timeStamp[0] = date;
            timeStamp[1] = hour;
            ticket.setDate(timeStamp);
            tickets.add(ticket);
        }
    }

    public void setPickedUp(boolean pickedUp) {
        isPickedUp = pickedUp;
    }

    public int getNumAttendenees() {
        return numAttendenees;
    }

    public int getReservationNum() {
        return reservationNum;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public int[] getTimeStamp() {
        return timeStamp;
    }

    public boolean isPickedUp() {
        return isPickedUp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
}
