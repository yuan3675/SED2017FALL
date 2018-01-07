public class BackpackingVacationBuilder implements VacationBuilder {
    private String day = null;
    private String hotel = null;
    private String reservation = null;
    private String specialEvent = null;
    private String tickets = null;

    @Override
    public void chooseDay(String day) {
        this.day = day;
    }

    @Override
    public void chooseHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public void chooseReservation(String reservation) {
        this.reservation = reservation;
    }

    @Override
    public void chooseSpecialEvent(String specialEvent) {
        this.specialEvent = specialEvent;
    }

    @Override
    public void chooseTicket(String tickets) {
        this.tickets = tickets;
    }

    @Override
    public Vacation getVacation() {
        return new BackpackVacation(day, hotel, specialEvent, reservation, tickets);
    }
}
