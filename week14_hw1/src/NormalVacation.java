public class NormalVacation extends Vacation {
    private String hotel;
    private String day;
    private String ticket;
    private String reservation;
    private String specialEvent;

    public NormalVacation(String day, String hotel, String specialEvent, String reservation, String ticket) {
        if (day == null) {
            this.day = "";
        }
        else {
            this.day = day;
        }
        if (hotel == null) {
            this.hotel = "";
        }
        else {
            this.hotel = hotel;
        }
        if (specialEvent == null) {
            this.specialEvent = "";
        }
        else {
            this.specialEvent = specialEvent;
        }
        if (reservation == null) {
            this.reservation = "";
        }
        else {
            this.reservation = reservation;
        }
        if (ticket == null) {
            this.ticket = "";
        }
        else {
            this.ticket = ticket;
        }
    }

    public String getHotel() {
        return hotel;
    }

    public String getDay() {
        return day;
    }

    public String getTicket() {
        return ticket;
    }

    public String getReservation() {
        return reservation;
    }

    public String getSpecialEvent() {
        return specialEvent;
    }
}
