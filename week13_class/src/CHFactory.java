public class CHFactory implements PizzaStyleFactory {
	public Pizza createCheesePizza(){
		Pizza cheesePizza = new CheeseCHStyle();
		return cheesePizza;
	}
	
	public Pizza createPepperoniPizza() {
		Pizza pepperoniPizza = new PepperoniCHStyle();
		return pepperoniPizza;
	}
}