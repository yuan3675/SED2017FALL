public class Ticket {
    private int seatNum = 0;
    private int[] date = new int[2];

    public void setDate(int[] date) {
        this.date = date;
    }

    public int[] getDate() {
        return date;
    }
}
