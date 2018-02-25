package decorator.ingredients;

import decorator.Pizza;
import decorator.PizzaDecorator;

public class Tomato extends PizzaDecorator{

	public Tomato(Pizza ingredient) {
		super(ingredient);
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", tomato";
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
