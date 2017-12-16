public class Milk extends Codiment {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return getCoffee().getPrice() + 0.2;
    }
}
