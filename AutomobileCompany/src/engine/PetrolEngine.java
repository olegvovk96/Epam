package engine;

public class PetrolEngine implements Engine{
	
	private int power;
	
	private double volume;
	
	public PetrolEngine(int power, double volume){
		this.power = power;
		this.volume = volume;
	}
	

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}



	@Override
	public void printEngineType() {
		System.out.println("petrol engine with power - " + this.power + " and volume - " + this.volume);
	}
}
