package gearbox;

public class ManualTransmission implements Gearbox{
	
	private int numberGears;
	
	public ManualTransmission(int numberGears){
		this.numberGears = numberGears;
	}

	public int getNumberGears() {
		return numberGears;
	}

	public void setNumberGears(int numberGears) {
		this.numberGears = numberGears;
	}

	@Override
	public void printGearboxType() {
		System.out.println("manual transmission with number of gears = " + this.numberGears);
	}
}
