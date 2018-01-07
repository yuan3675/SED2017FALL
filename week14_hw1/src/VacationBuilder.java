public interface VacationBuilder {
    public void chooseDay(String day);
    public void chooseHotel(String hotel);
    public void chooseReservation(String reservation);
    public void chooseSpecialEvent(String specialEvent);
    public void chooseTicket(String tickets);
    public Vacation getVacation();
}
