package main;

import engine.ElectricEngine;
import engine.PetrolEngine;
import gearbox.AutomaticTransmission;
import gearbox.ManualTransmission;
import vehicle.Car;
import vehicle.ElectricСar;
import vehicle.Vehicle;

public class Main {

	public static void main(String[] args) {
		Vehicle car = new Car(new PetrolEngine(130, 1.8), new ManualTransmission(6));
		car.printVehicle();
		car.getEngine();
		car.getGearbox();
		
		System.out.println("------------------------");
		
		Vehicle electricCar = new ElectricСar(new ElectricEngine(107), new AutomaticTransmission());
		electricCar.printVehicle();
		electricCar.getEngine();
		electricCar.getGearbox();
	}

}
