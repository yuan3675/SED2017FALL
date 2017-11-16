public class Customer {
    private String name;
    private String phone;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void call(String[] action, BookingService bookingService, Staff staff) {
        staff.check(action, bookingService);
    }
}
