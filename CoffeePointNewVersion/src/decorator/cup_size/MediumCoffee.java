package decorator.cup_size;

import decorator.BasicCoffee;

public class MediumCoffee extends BasicCoffee{

	@Override
	public int price() {
		return 1200;
	}

	@Override
	public String toString() {
		return "BasicMediumCoffee: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}
}
