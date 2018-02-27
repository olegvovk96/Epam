package main;

import java.util.Scanner;

import customer_information.Customer;
import decorator.*;
import decorator.cup_size.*;
import decorator.ingredients.coffee.*;
import decorator.ingredients.hot_dog.*;
import strategy.*;


public class CoffeePointServise {
	
	private Coffee coffee;
	
	private HotDog hotDog;
	
	private Customer customer;
	
	private Scanner sc;
	
	public CoffeePointServise(Customer customer){
		this.customer = customer;
		sc = new Scanner(System.in);
		makeOrder();
		sc.close();
	}
	
	private void makeOrder(){
		int category;
		while(true){
			System.out.println("Make an order[Enter 1-q]:\n"
					+ "1. Order coffee\n"
		            + "2. Order hot dog\n"
					+ "3. Order coffee and hot dog\n"
					+ "4. Complete the order / Nothing");
			category = sc.nextInt();
			if(category == 1) {
				orderCoffee();
				showBill();
				paymentOrder();
			} else if(category == 2) {
				orderHotDog();
				showBill();
				paymentOrder();
			} else if(category == 3){
				orderCoffee();
				orderHotDog();
				showBill();
				paymentOrder();
			} 
			else if(category == 4) {
				break;
			}
		}
	}
	
	private void orderCoffee(){
		boolean isRun = true;
		System.out.println("Choose size of coffee[Enter 1-3]:\n"
				             + "1. small coffee\n"
				             + "2. medium coffee\n"
				             + "3. large coffee");
		while(true){
			int category = sc.nextInt();
			if(category == 1){
				coffee = new SmallCoffee();
				break;
			} else if(category == 2){
				coffee = new MediumCoffee();
				break;
			} else if(category == 3){
				coffee = new LargeCoffee();
				break;
			}
		}
		System.out.println("Choose ingredients for coffee[Enter 1-q]: \n"
		          + "1. Chocolate\n"
		          + "2. Cream\n"
		          + "3. Milk\n"
		          + "4. Sugar\n"
		          + "5. Vanilla\n"
		          + "q. Exit");
		while(isRun){
			switch (sc.next()) {
			case "1":{
				coffee = new Chocolate(coffee);
				break;
			}
			case "2":{
				coffee = new Cream(coffee);
				break;
			}
			case "3":{
				coffee = new Milk(coffee);
				break;
			}
			case "4":{
				coffee = new Sugar(coffee);
				break;
			}
			case "5":{
				coffee = new Vanilla(coffee);
				break;
			}
			default:{
				isRun = false;
				break;
			}
			}
		}
	}
	
	private void orderHotDog(){
		boolean isRun = true;
		hotDog = new BasicHotDog();
		System.out.println("Choose ingredients for hot dog[Enter 1-q]: \n"
		          + "1. Ketchup\n"
		          + "2. Mustard\n"
		          + "3. Onion\n"
		          + "4. Sausage\n"
		          + "q. Exit");
		while(isRun){
			switch (sc.next()) {
			case "1":{
				hotDog = new Ketchup(hotDog);
				break;
			}
			case "2":{
				hotDog = new Mustard(hotDog);
				break;
			}
			case "3":{
				hotDog = new Onion(hotDog);
				break;
			}
			case "4":{
				hotDog = new Sausage(hotDog);
				break;
			}
			default:{
				isRun = false;
				break;
			}
			}
		}
	}
	
	private void showBill(){
		if(coffee != null && hotDog != null){
			String totalPrice = (coffee.price() + hotDog.price()) / 100 + "." + (coffee.price() + hotDog.price()) % 100 ;
			System.out.println("\nBill\n" + coffee + "\n" + hotDog + "\ntotalPrice: " + totalPrice);
		} else if(coffee != null){
			System.out.println("\nBill\n" + coffee);
		} else if(hotDog != null){
			System.out.println("\nBill\n" + hotDog);
		}
	}
	
	private void checkPayment(Payment payment){
		if(coffee != null && hotDog != null){
			payment.makePayment(coffee.price() + hotDog.price(), customer);
		} else if(coffee != null){
			payment.makePayment(coffee.price(), customer);
		} else if(hotDog != null){
			payment.makePayment(hotDog.price(), customer);
		}
	}
	
	
	private void paymentOrder(){
		StringBuilder category;
		Payment payment;
		System.out.println("\nChoose a payment method[Enter 1-3]: \n"
				            + "1. Card Payment\n"
				            + "2. Cash Payment\n"
				            + "3. Bonus Payment");
		while(true){
			category = new StringBuilder(sc.next());
			if(category.toString().equals("1")) {
				payment = new CardPayment();
				payment.paymentDetails(customer);
				checkPayment(payment);
				break;
			} else if(category.toString().equals("2")) {
				payment = new CashPayment();
				checkPayment(payment);
				break;
			} else if(category.toString().equals("3")) {
				payment = new BonusPayment();
				checkPayment(payment);
				break;
			} else {
				System.out.println("You haven't paid the order");
				System.out.println("\nChoose a payment method[Enter 1-3]: \n"
			            + "1. Card Payment\n"
			            + "2. Cash Payment\n"
			            + "3. Bonus Payment");
				continue;
			}
		}
		System.out.println(customer);
	} 
}
