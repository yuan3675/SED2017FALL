public abstract class Codiment implements Coffee {
    private double price;
    private Coffee coffee;

    public Codiment(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    @Override
    public abstract double getPrice();
}
