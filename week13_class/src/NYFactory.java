public class NYFactory implements PizzaStyleFactory {
	public Pizza createCheesePizza(){
		Pizza cheesePizza = new CheeseNYStyle();
		return cheesePizza;
	}

	public Pizza createPepperoniPizza() {
		Pizza pepperoniPizza = new PepperoniNYStyle();
		return pepperoniPizza;
	}
}