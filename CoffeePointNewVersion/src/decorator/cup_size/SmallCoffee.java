package decorator.cup_size;

import decorator.BasicCoffee;

public class SmallCoffee extends BasicCoffee{

	@Override
	public int price() {
		return 800;
	}
	
	
	@Override
	public String toString() {
		return "BasicSmallCoffee: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
}
