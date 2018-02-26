package fish;

public class FishShop implements Comparable<FishShop>{
	
	private LiveFish liveFish;
	
	private FrozenFish frozenFish;
	
	private Herring herring;
	
	
	public FishShop(LiveFish liveFish){
		this.liveFish = liveFish;
	}
	
	public FishShop(FrozenFish frozenFish){
		this.frozenFish = frozenFish;
	}

	public FishShop(Herring herring){
		this.herring = herring;
	}
	
	public LiveFish getLiveFish() {
		return liveFish;
	}

	public void setLiveFish(LiveFish liveFish) {
		this.liveFish = liveFish;
	}

	public FrozenFish getFrozenFish() {
		return frozenFish;
	}

	public void setFrozenFish(FrozenFish frozenFish) {
		this.frozenFish = frozenFish;
	}

	public Herring getHerring() {
		return herring;
	}

	public void setHerring(Herring herring) {
		this.herring = herring;
	}

	@Override
	public int compareTo(FishShop o) {
		if(getHerring().getWeight() == o.getHerring().getWeight()
				&& getFrozenFish().getWeight() == o.getFrozenFish().getWeight()
				   && getLiveFish().getWeight() == o.getLiveFish().getWeight())  
			return 0;  
			else if(getHerring().getWeight() > o.getHerring().getWeight()
					&& getFrozenFish().getWeight() > o.getFrozenFish().getWeight()
					   && getLiveFish().getWeight() > o.getLiveFish().getWeight())  
			return 1;  
			else  
			return -1;  
	}
	
	
}
