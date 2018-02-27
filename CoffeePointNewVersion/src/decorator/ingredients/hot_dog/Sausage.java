package decorator.ingredients.hot_dog;

import decorator.HotDog;
import decorator.HotDogDecorator;

public class Sausage extends HotDogDecorator{
	
	private int cost;
	
	public Sausage(HotDog hotDog) {
		super(hotDog);
		this.cost = 550;
	}
	
	@Override
	public String getDescription() {
		return super.getDescription() + ", sausage";
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
