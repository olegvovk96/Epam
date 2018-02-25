package strategy;

import java.util.Scanner;

import customer_information.Customer;

public class CardPayment implements Payment{

	
	@Override
	public void makePayment(int price, Customer customer) {
		if(customer.getCard().getBalance() > price) {
			customer.getCard().setBalance(customer.getCard().getBalance() - price);
			System.out.println("The payment was successful");
			customer.getBonusCard().setBalance(customer.getBonusCard().getBalance() +
					(price / customer.getBonusCard().getBonusToMoney()));
		} else {
			System.out.println("Not enough money");
		} 
	}
	
	@Override
	public void paymentDetails(Customer customer){
		Scanner sc = new Scanner(System.in);
		System.out.println("Input card number:");
		customer.getCard().setNumberCard(sc.next());
		System.out.println("Input CVV:");
		customer.getCard().setCvv(sc.nextInt());
		sc.close();
	}

}
