package fish;

public class FrozenFish implements Fish{

	private int price;
	
	private String item;
	
	private double weight;
	
	public FrozenFish(int price, String item, double weight) {
		this.price = price;
		this.item = item;
		this.weight = weight;
	}

	@Override
	public void setFishItem(String item) {
		this.item = item;
	}

	@Override
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	
}
