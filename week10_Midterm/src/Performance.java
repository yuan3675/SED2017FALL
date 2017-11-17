public class Performance {
    private int[] startTime = new int[2];
    private int availableSeatNum = 0;

    public void setStartTime(int[] time) {
        this.startTime = time;
    }

    public int[] getStartTime() {
        return startTime;
    }

    public void setAvailableSeatNum(int availableSeatNum) {
        this.availableSeatNum = availableSeatNum;
    }

    public int getAvailableSeatNum() {
        return availableSeatNum;
    }
}
