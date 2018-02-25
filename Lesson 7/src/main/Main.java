package main;

import customer_information.*;

public class Main {

	public static void main(String[] args) {
		new PizzaServise(new Customer("Taras", "Legan", new Cash(10000), new CreditCard(70000), new BonusCard(300)));
	}

}
