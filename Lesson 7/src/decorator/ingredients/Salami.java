package decorator.ingredients;

import decorator.Pizza;
import decorator.PizzaDecorator;

public class Salami extends PizzaDecorator{

	public Salami(Pizza ingredient) {
		super(ingredient);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", salami";
	}

	@Override
	public int price() {
		return super.price() + 1400;
	}
	
	@Override
	public String toString() {
		return "StandartPizza: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
}
