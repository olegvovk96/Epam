package drink;

import java.util.List;

import main.PriceList;

public class Coffee extends PriceList{
	
	private CoffeeState state;
	
	private CupSize size;
	
	private Additive additive;
	
	public Coffee(String name, int price, CoffeeState state, CupSize size, Additive additive){
		super(name, price);
		this.state = state;
		this.size = size;
		this.additive = additive;
	}
	
	//повератає ціну кави, вибраної користувачем з меню
	public static int addCoffee(List<Coffee> coffee, int subCategory){
		int price = 0;
		for (int i = 0; i < coffee.size(); i++) {
			if(i == subCategory){
				price += coffee.get(i).getPrice();
			}
		}
		return price;
	}

	@Override
	public String toString() {
		return "name = " + getName() + ", price = " + getPrice()/100 + "." + getPrice()%100 + " UAH" 
				+ ", coffee state = " + this.state + ", cup size = " + this.size + ", additive = " + this.additive + "\n";
	}

	
	public CoffeeState getState() {
		return state;
	}

	public void setState(CoffeeState state) {
		this.state = state;
	}

	public CupSize getSize() {
		return size;
	}

	public void setSize(CupSize size) {
		this.size = size;
	}

	public Additive getAdditive() {
		return additive;
	}

	public void setAdditive(Additive additive) {
		this.additive = additive;
	}

}
