public class Mocha extends Codiment {
    public Mocha(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return getCoffee().getPrice() + 0.25;
    }
}
