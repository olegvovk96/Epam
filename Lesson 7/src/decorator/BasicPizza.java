package decorator;

public class BasicPizza implements Pizza{

	@Override
	public String getDescription() {
		return "dough, tomato paste";
	}

	@Override
	public int price() {
		return 1750;
	}
	
}
