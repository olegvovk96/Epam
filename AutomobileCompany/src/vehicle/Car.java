package vehicle;

import engine.Engine;
import gearbox.Gearbox;

public class Car implements Vehicle{

	protected Engine engine;
	
	protected Gearbox gearbox;
	
	public Car(Engine engine, Gearbox gearbox){
		this.engine = engine;
		this.gearbox = gearbox;
	}

	@Override
	public void printVehicle() {
		System.out.println("Car contains: ");
	}
	
	@Override
	public void getEngine() {
		engine.printEngineType();
	}

	@Override
	public void getGearbox() {
		gearbox.printGearboxType();
	}

}
