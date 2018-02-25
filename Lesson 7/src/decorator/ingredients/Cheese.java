package decorator.ingredients;

import decorator.Pizza;
import decorator.PizzaDecorator;

public class Cheese extends PizzaDecorator{

	public Cheese(Pizza ingredient) {
		super(ingredient);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", cheese";
	}

	@Override
	public int price() {
		return super.price() + 1400;
	}
	
	@Override
	public String toString() {
		return "CheesePizza: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
	
}
