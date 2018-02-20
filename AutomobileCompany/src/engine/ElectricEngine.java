package engine;

public class ElectricEngine implements Engine{

	private int power;
	
	public ElectricEngine(int power){
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public void printEngineType() {
		System.out.println("electric engine with power - " + this.power);
	}
}
