package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dishes.HotDog;
import dishes.HotDogType;
import dishes.Sandwich;
import dishes.SandwichType;
import drink.Additive;
import drink.Coffee;
import drink.CoffeeState;
import drink.CupSize;

public class Main {

	public static void main(String[] args) {
		
		List<Coffee> coffee = new ArrayList<>();
		coffee.add(new Coffee("Late", 550, CoffeeState.HOT, CupSize.SMALL, Additive.NONE));
		coffee.add(new Coffee("Late", 950, CoffeeState.HOT, CupSize.LARGE, Additive.NONE));
		coffee.add(new Coffee("Late", 1250, CoffeeState.HOT, CupSize.EXTRA_LARGE, Additive.NONE));
		coffee.add(new Coffee("Black", 650, CoffeeState.COLD, CupSize.MEDIUM, Additive.NONE));
		coffee.add(new Coffee("Black", 650, CoffeeState.HOT, CupSize.MEDIUM, Additive.NONE));
		coffee.add(new Coffee("Black", 1450, CoffeeState.HOT, CupSize.MEDIUM, Additive.CREAM_AND_CHOCOLATE));
		coffee.add(new Coffee("Black", 1150, CoffeeState.HOT, CupSize.MEDIUM, Additive.CREAM));
		coffee.add(new Coffee("Black", 1750, CoffeeState.HOT, CupSize.MEDIUM, Additive.MILK_AND_CREAM));
		coffee.add(new Coffee("Black", 2200, CoffeeState.HOT, CupSize.MEDIUM, Additive.MILK_CREAM_AND_CHOCOLATE));
		coffee.add(new Coffee("Black", 950, CoffeeState.HOT, CupSize.MEDIUM, Additive.MILK));
		
		List<Sandwich> sandwiches = new ArrayList<>();
		sandwiches.add(new Sandwich("Sandwich", 3500, SandwichType.HAM));
		sandwiches.add(new Sandwich("Sandwich", 2850, SandwichType.CHICKEN));
		sandwiches.add(new Sandwich("Sandwich", 3200, SandwichType.BACON));
		sandwiches.add(new Sandwich("Sandwich", 2500, SandwichType.SALAMI));
		
		List<HotDog> hotDogs = new ArrayList<>();
		hotDogs.add(new HotDog("HotDog", 1500, HotDogType.CLASSICCAL));
		hotDogs.add(new HotDog("HotDog", 2200, HotDogType.DOUBLE));
		hotDogs.add(new HotDog("HotDog", 1800, HotDogType.HUNTING));
		hotDogs.add(new HotDog("HotDog", 1400, HotDogType.FRENCH));
		
		
		Customer customer = new Customer("Ihor", "Byrak", new BonusCard(200), 400, 3000, PaymentType.CREDIT_CARD);
		Order order = new Order(UUID.randomUUID());
		order.makeOrder(coffee, sandwiches, hotDogs);
		order.paymentOrder(customer);
	}

}
