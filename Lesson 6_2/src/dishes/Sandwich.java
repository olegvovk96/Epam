package dishes;

import java.util.List;

import main.PriceList;

public class Sandwich extends PriceList{
	
	private SandwichType type;
	
	public Sandwich(String name, int price, SandwichType type){
		super(name, price);
		this.type = type;
	}
	
	//повератає ціну бутерброда, вибраного користувачем з меню 
	public static int addSandwich(List<Sandwich> sandwiches, int subCategory){
		int price = 0;
		for (int i = 0; i < sandwiches.size(); i++) {
			if(i == subCategory){
				price += sandwiches.get(i).getPrice();
			}
		}
		return price;
	}
	
	@Override
	public String toString() {
		return "name = " + getName() + ", price = " + getPrice()/100 + "." + getPrice()%100 + " UAH"
	          + ", sandwich type = " + this.type + "\n";
	}

	public SandwichType getType() {
		return type;
	}

	public void setType(SandwichType type) {
		this.type = type;
	}
	

}
