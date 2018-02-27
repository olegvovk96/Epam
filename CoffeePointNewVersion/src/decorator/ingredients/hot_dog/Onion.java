package decorator.ingredients.hot_dog;

import decorator.HotDog;
import decorator.HotDogDecorator;

public class Onion extends HotDogDecorator{

	private int cost;
	
	public Onion(HotDog hotDog) {
		super(hotDog);
		this.cost = 200;
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", onion";
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
