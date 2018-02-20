package vehicle;

import engine.Engine;
import gearbox.Gearbox;

public class ElectricBus implements Vehicle{

	protected Engine engine;
	
	protected Gearbox gearbox;
	
	public ElectricBus(Engine engine, Gearbox gearbox){
		this.engine = engine;
		this.gearbox = gearbox;
	}
	
	@Override
	public void printVehicle() {
		System.out.println("Electric bus contains: ");
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
