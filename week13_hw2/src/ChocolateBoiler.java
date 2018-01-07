public class ChocolateBoiler {
    private static ChocolateBoiler instance = null;
    private boolean isEmpty = true;
    private boolean isBoiled = false;

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            instance = new ChocolateBoiler();
        }
        return instance;
    }

    public void Fill() {
        if (isEmpty == true && isBoiled == false) {
            System.out.println("Fill chocolate");
            isEmpty = false;
        }
    }
    public void Boil() {
        if (isEmpty == false && isBoiled == false) {
            System.out.println("Boil chocolate");
            isBoiled = true;
        }
    }
    public void Drain() {
        if (isEmpty == false && isBoiled == true) {
            System.out.println("Drain the boiled chocolate");
            isEmpty = true;
            isBoiled = false;
        }
    }
}
