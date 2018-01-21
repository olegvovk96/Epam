package main;

import java.util.List;

import dishes.HotDog;
import dishes.Sandwich;
import drink.Coffee;


public class CoffeePoint {

	private String name;
	
	private static boolean isCountBonuses;

	
	public static void showMenu(List<Coffee> coffee, List<Sandwich> sandwiches, List<HotDog> hotDogs){
		System.out.println("1. Coffee:");
		subMenu(coffee);
		System.out.println("\n2. Sandwiches:");
		subMenu(sandwiches);
		System.out.println("\n3. HotDogs:");
		subMenu(hotDogs);
	}
	
	private static <T> void subMenu(List<T> lists){
		for (int i = 0; i < lists.size(); i++) {
			System.out.print(i + ". " + lists.get(i));
		}
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static boolean getIsCountBonuses() {
		return isCountBonuses;
	}

	public static void setIsCountBonuses(boolean isCountBonuses) {
		CoffeePoint.isCountBonuses = isCountBonuses;
	}

	
	
}
