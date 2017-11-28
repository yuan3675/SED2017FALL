public class Milk {
    private Brand brand;
    private int liter;

    public Milk(Brand brand, int liter) {
        this.brand = brand;
        this.liter = liter;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getLiter() {
        return liter;
    }

    public void setLiter(int liter) {
        this.liter = liter;
    }
}
