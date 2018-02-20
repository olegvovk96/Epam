package vehicle;

import engine.Engine;
import gearbox.Gearbox;

public class Bus implements Vehicle{

	protected Engine engine;
	
	protected Gearbox gearbox;
	
	public Bus(Engine engine, Gearbox gearbox){
		this.engine = engine;
		this.gearbox = gearbox;
	}
	
	@Override
	public void printVehicle() {
		System.out.println("Bus contains: ");
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
