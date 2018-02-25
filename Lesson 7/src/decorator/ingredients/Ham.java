package decorator.ingredients;

import decorator.Pizza;
import decorator.PizzaDecorator;

public class Ham extends PizzaDecorator{

	public Ham(Pizza ingredient) {
		super(ingredient);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", ham";
	}

	@Override
	public int price() {
		return super.price() + 1700;
	}
	
	@Override
	public String toString() {
		return "MeatPizza: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
	
}
