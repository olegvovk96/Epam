package decorator.ingredients;

import decorator.Pizza;
import decorator.PizzaDecorator;

public class Olive extends PizzaDecorator{

	public Olive(Pizza ingredient) {
		super(ingredient);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", olive";
	}

	@Override
	public int price() {
		return super.price() + 1100;
	}

	@Override
	public String toString() {
		return "StandartPizza: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
}
