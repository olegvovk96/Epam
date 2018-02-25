package decorator;


public abstract class PizzaDecorator implements Pizza{

	protected Pizza ingredient;
	
	public PizzaDecorator(Pizza ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String getDescription() {
		return ingredient.getDescription();
	}

	@Override
	public int price() {
		return ingredient.price();
	}
	
	
	
}
