public class PizzaStore {
    public void offer(PizzaStyleFactory factory, String flavor) {
        if (flavor.equals("Cheese")) {
            Pizza pizza = factory.createCheesePizza();
            System.out.println("Prepare " + flavor + " Pizza with " + pizza.getDough() + " and " + pizza.getSauce());
        }
        else if (flavor.equals("Pepperoni")) {
            Pizza pizza = factory.createPepperoniPizza();
            System.out.println("Prepare " + flavor + " Pizza with " + pizza.getDough() + " and " + pizza.getSauce());
        }
    }
}
