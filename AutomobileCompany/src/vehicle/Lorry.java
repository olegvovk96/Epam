package vehicle;

import engine.Engine;
import gearbox.Gearbox;

public class Lorry implements Vehicle{

	protected Engine engine;
	
	protected Gearbox gearbox;
	
	public Lorry(Engine engine, Gearbox gearbox){
		this.engine = engine;
		this.gearbox = gearbox;
	}
	
	@Override
	public void printVehicle() {
		System.out.println("Lorry contains: ");
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
