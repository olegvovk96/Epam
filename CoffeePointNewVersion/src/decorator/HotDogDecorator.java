package decorator;

public abstract class HotDogDecorator implements HotDog{
	
	protected HotDog hotDog;

	public HotDogDecorator(HotDog hotDog) {
		this.hotDog = hotDog;
	}

	@Override
	public String getDescription() {
		return hotDog.getDescription();
	}

	@Override
	public int price() {
		return hotDog.price();
	}
	
	
}
