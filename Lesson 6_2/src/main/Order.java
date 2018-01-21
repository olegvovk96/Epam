package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import dishes.HotDog;
import dishes.Sandwich;
import drink.Coffee;

public class Order {
	
	public UUID numberOrder;
	
	private List<Integer> prices;
	
	
	public Order(UUID numberOrder){
		prices = new ArrayList<>();
		this.numberOrder = numberOrder;
	}
	
	public void makeOrder(List<Coffee> coffee, List<Sandwich> sandwiches, List<HotDog> hotDogs){
		int subCategory;
		CoffeePoint.showMenu(coffee, sandwiches, hotDogs);
		Scanner sc = new Scanner(System.in);
		System.out.println("Chose coffee enter - 1, sandwiches enter - 2, hotdogs enter - 3");
		int category = sc.nextInt();
		if(category == 1){
			System.out.println("Chose the coffee and enter the number from menu");
			subCategory = sc.nextInt();
			prices.add(Coffee.addCoffee(coffee, subCategory));
		} else if(category == 2){
			System.out.println("Chose the sandwich and enter the number from menu");
			subCategory = sc.nextInt();
			prices.add(Sandwich.addSandwich(sandwiches, subCategory));
		} else if(category == 3){
			System.out.println("Chose the hot dog and enter the number from menu");
			subCategory = sc.nextInt();
			prices.add(HotDog.addHotDog(hotDogs, subCategory));
		}
		System.out.println("Enter 1 to add order or 0 to exit: ");
		int repeat = sc.nextInt();
		if(repeat == 1){
			makeOrder(coffee, sandwiches, hotDogs);
		} 
		sc.close();
	}
	
	// метод підраховує суму замовлення і повертає її
	private int calculateAmount(){
		int result = 0;
		for (Integer pr : prices) {
			result += pr;
		}
		return result;
	}
	
	public void paymentOrder(Customer customer){
		int min = prices.get(0); // найменша ціна одиниці замовлення буде відмінусована, якщо розраховуватися бонусами і готівкою
		int calculateAmountOrder = calculateAmount();
		int newAmount = 0;
		customer.setCash(customer.getCash() * 100); // в копійках
		customer.setBalanceCreditCard(customer.getBalanceCreditCard() * 100);
		if(customer.getPayment() == PaymentType.CASH_BONUS){
			if(customer.getBonusCard().bonuses == 300){
				CoffeePoint.setIsCountBonuses(true);
				// Якщо клієнт замовляє лише одну одиницю, він отримує її безкоштовно
				if(prices.size() == 1){
					System.out.println("Your order is free");
					customer.getBonusCard().setBonuses(customer.getBonusCard().getBonuses() - 300);
				} else{
					for (int i = 0; i < prices.size(); i++) {
						if(min > prices.get(i)){
							min = prices.get(i);
						}
					}
					newAmount = calculateAmountOrder - min;
					customer.setCash(customer.getCash() - newAmount);
					customer.getBonusCard().setBonuses(customer.getBonusCard().getBonuses() - 300);
				}
				
			} else{
				CoffeePoint.setIsCountBonuses(false);
			}
		} else if(customer.getPayment() == PaymentType.CASH
				&& customer.getCash() >= calculateAmountOrder){
			customer.setCash(customer.getCash() - calculateAmountOrder);			
			customer.getBonusCard().setBonuses(customer.getBonusCard().getBonuses() + (calculateAmountOrder / 100));
		} else if(customer.getPayment() == PaymentType.CREDIT_CARD
				&& customer.getBalanceCreditCard() >= calculateAmountOrder){
			customer.setBalanceCreditCard(customer.getBalanceCreditCard() - calculateAmountOrder);
			customer.getBonusCard().setBonuses(customer.getBonusCard().getBonuses() + (calculateAmountOrder / 100));
		}
	}


	public UUID getNumberOrder() {
		return numberOrder;
	}


	public void setNumberOrder(UUID numberOrder) {
		this.numberOrder = numberOrder;
	}

	public List<Integer> getAmount() {
		return prices;
	}

	public void setAmount(List<Integer> prices) {
		this.prices = prices;
	}
	
}
