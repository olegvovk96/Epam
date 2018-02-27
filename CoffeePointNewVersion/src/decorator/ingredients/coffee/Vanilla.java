package decorator.ingredients.coffee;

import decorator.Coffee;
import decorator.CoffeeDecorator;

public class Vanilla extends CoffeeDecorator{

	private int cost;
	
	public Vanilla(Coffee coffee) {
		super(coffee);
		this.cost = 500;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", vanilla";
	}

	@Override
	public int price() {
		return super.price() + cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "CoffeeWithIngredients: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
	
}
