package decorator.ingredients.hot_dog;

import decorator.HotDog;
import decorator.HotDogDecorator;

public class Ketchup extends HotDogDecorator{

	private int cost;
	
	public Ketchup(HotDog hotDog) {
		super(hotDog);
		this.cost = 400;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", ketchup";
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
		return "HotDogWithIngredients: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
	
}
