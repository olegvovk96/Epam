package decorator.cup_size;

import decorator.BasicCoffee;

public class LargeCoffee extends BasicCoffee{

	@Override
	public int price() {
		return 1700;
	}
	
	@Override
	public String toString() {
		return "BasicLargeCoffee: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
	
}
