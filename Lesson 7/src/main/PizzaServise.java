package main;

import java.util.Scanner;

import customer_information.Customer;
import decorator.*;
import decorator.ingredients.*;
import strategy.*;


public class PizzaServise {
	
	private Pizza pizza;
	
	private Customer customer;
	
	private Scanner sc;
	
	public PizzaServise(Customer customer){
		this.customer = customer;
		sc = new Scanner(System.in);
		makeOrder();
		showBill();
		paymentOrder();
		sc.close();
	}
	
	private void makeOrder(){
		boolean isRun = true;
		pizza = new BasicPizza();
		System.out.println("Choose ingredients for pizza[Enter 1-q]: \n"
		          + "1. Cheese\n"
		          + "2. Ham\n"
		          + "3. Mushroom\n"
		          + "4. Olive\n"
		          + "5. Pineapple\n"
		          + "6. Salami\n"
		          + "7. Tomato\n"
		          + "q. Exit");
		while(isRun){
			switch (sc.next()) {
			case "1":{
				pizza = new Cheese(pizza);
				break;
			}
			case "2":{
				pizza = new Ham(pizza);
				break;
			}
			case "3":{
				pizza = new Mushroom(pizza);
				break;
			}
			case "4":{
				pizza = new Olive(pizza);
				break;
			}
			case "5":{
				pizza = new Pineapple(pizza);
				break;
			}
			case "6":{
				pizza = new Salami(pizza);
				break;
			}
			case "7":{
				pizza = new Tomato(pizza);
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
		System.out.println("\nBill\n" + pizza);
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
				payment.makePayment(pizza.price(), customer);
				break;
			} else if(category.toString().equals("2")) {
				payment = new CashPayment();
				payment.makePayment(pizza.price(), customer);
				break;
			} else if(category.toString().equals("3")) {
				payment = new BonusPayment();
				payment.makePayment(pizza.price(), customer);
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
