import java.util.ArrayList;

public class BoxOfficeStaff extends Staff {
    @Override
    public boolean check(String[] action, BookingService bookingService) {
        if(action[0].equals("pickup")) {
            int reservationNum = Integer.parseInt(action[2]);
            int[] timeStamp = new int[2];
            String[] time = action[1].split(",");
            timeStamp[0] = Integer.parseInt(time[0]);
            timeStamp[1] = Integer.parseInt(time[1]);

            bookingService.checkTime(timeStamp);
            bookingService.pickUp(timeStamp, reservationNum, action[3], action[4]);
            return false;
        }
        else if(action[0].equals("time")) {
            int[] timeStamp = new int[2];
            String[] time = action[1].split(",");
            timeStamp[0] = Integer.parseInt(time[0]);
            timeStamp[1] = Integer.parseInt(time[1]);
            bookingService.checkTime(timeStamp);
            return false;
        }
        return true;
    }
}
