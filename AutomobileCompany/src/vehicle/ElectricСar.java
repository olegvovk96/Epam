package vehicle;

import engine.Engine;
import gearbox.Gearbox;

public class ElectricСar implements Vehicle{

	protected Engine engine;
	
	protected Gearbox gearbox;
	
	public ElectricСar(Engine engine, Gearbox gearbox){
		this.engine = engine;
		this.gearbox = gearbox;
	}
	
	@Override
	public void printVehicle() {
		System.out.println("Electric car contains: ");
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
