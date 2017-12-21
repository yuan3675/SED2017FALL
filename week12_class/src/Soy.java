public class Soy extends Codiment {
    public Soy(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return getCoffee().getPrice() + 0.1;
    }
}
