package decorator.ingredients;

import decorator.Pizza;
import decorator.PizzaDecorator;

public class Mushroom extends PizzaDecorator{
	
	public Mushroom(Pizza ingredient) {
		super(ingredient);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", mushroom";
	}

	@Override
	public int price() {
		return super.price() + 1000;
	}
	
	@Override
	public String toString() {
		return "StandartPizza: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
}
