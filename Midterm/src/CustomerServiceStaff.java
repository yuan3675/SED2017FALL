import java.util.ArrayList;

public class CustomerServiceStaff extends Staff {
    @Override
    public boolean check(String[] action, BookingService bookingService) {
        if (action[0].equals("book")) {
            ArrayList<Performance> performances = bookingService.getPerformances();
            for (int i = 0; i< performances.size(); i++) {
                Performance performance = performances.get(i);
                int[] time = performance.getStartTime();
                if (time[0] == Integer.parseInt(action[2])) {
                    int available = performance.getAvailableSeatNum();
                    if (available >= Integer.parseInt(action[5])) {
                        String[] s = action[1].split(",");
                        int[] timeStamp = new int[2];
                        timeStamp[0] = Integer.parseInt(s[0]);
                        timeStamp[1] = Integer.parseInt(s[1]);
                        bookingService.checkTime(timeStamp);
                        bookingService.book(timeStamp, Integer.parseInt(action[2]), action[3], action[4], Integer.parseInt(action[5]));
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }

        }
        else if (action[0].equals("cancel")) {
            int reservationNum = Integer.parseInt(action[2]);
            int[] timeStamp = new int[2];
            String[] time = action[1].split(",");
            timeStamp[0] = Integer.parseInt(time[0]);
            timeStamp[1] = Integer.parseInt(time[1]);

            bookingService.checkTime(timeStamp);
            bookingService.cancel(timeStamp, reservationNum, action[3], action[4]);
            return false;
        }
        else {
            System.out.println("Staff command error!");
            return false;
        }
        return false;
    }
}
