package decorator;

public class BasicHotDog implements HotDog{

	@Override
	public String getDescription() {
		return "roll, sausage";
	}

	@Override
	public int price() {
		return 700;
	}
	
	@Override
	public String toString() {
		return "BasicHotDog: \n" + "Ingredients: " + getDescription() + "\nPrice = " + price() / 100 + "." + price() % 100 + " грн.";
	}

}
