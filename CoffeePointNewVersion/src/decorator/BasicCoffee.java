package decorator;

public class BasicCoffee implements Coffee{

	@Override
	public String getDescription() {
		return "water, coffee beans";
	}

	@Override
	public int price() {
		return 0;
	}

}
