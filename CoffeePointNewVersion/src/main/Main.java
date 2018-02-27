package main;

import customer_information.*;

public class Main {

	public static void main(String[] args) {
		new CoffeePointServise(new Customer("Solomiya", "Zakharko", new Cash(10000), new CreditCard(70000), new BonusCard(300)));
	}

}
