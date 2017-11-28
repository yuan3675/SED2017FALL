public class Order {
    private Household household;
    private Milk milk;
    private int month;

    public Order(Household household, Milk milk, int month) {
        this.household = household;
        this.milk = milk;
        this.month = month;
    }

    public Household getHousehold() {
        return household;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public Milk getMilk() {
        return milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
