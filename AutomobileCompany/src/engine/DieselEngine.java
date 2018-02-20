package engine;

public class DieselEngine implements Engine{
	
	private int power;
	
	private double volume;	

	public DieselEngine(int power, double volume){
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
		System.out.println("diesel engine with power - " + this.power + " and volume - " + this.volume);
	}
	
	
}
