package dishes;

import java.util.List;

import main.PriceList;

public class HotDog extends PriceList{
	private HotDogType type;
	
	public HotDog(String name, int price, HotDogType type){
		super(name, price);
		this.type = type;
	}
	
	//повератає ціну хот дога, вибраного користувачем з меню   
	public static int addHotDog(List<HotDog> hotDogs, int subCategory){
		int price = 0;
		for (int i = 0; i < hotDogs.size(); i++) {
			if(i == subCategory){
				price += hotDogs.get(i).getPrice();
			}
		}
		return price;
	}
	
	@Override
	public String toString() {
		return "name = " + getName() + ", price = " + getPrice()/100 + "." + getPrice()%100 + " UAH" 
				+ ", hot dog type = " + this.type +  "\n";
	}
	
	
	
}
