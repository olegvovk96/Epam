package strategy;

import customer_information.Customer;

public class CashPayment implements Payment{

	@Override
	public void makePayment(int price, Customer customer) {
		if(customer.getCash().getBalance() > price){
			customer.getCash().setBalance(customer.getCash().getBalance() - price);
			System.out.println("The payment was successful");
			customer.getBonusCard().setBalance(customer.getBonusCard().getBalance() +
					(price / customer.getBonusCard().getBonusToMoney()));
		} else {
			System.out.println("Not enough money");
		} 
	}

}
