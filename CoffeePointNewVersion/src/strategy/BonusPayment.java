package strategy;

import customer_information.Customer;

public class BonusPayment implements Payment{
	
	@Override
	public void makePayment(int price, Customer customer) {
		int needBonuses = price / 100;
		if(price <= 7000 && customer.getBonusCard().getBalance() >= needBonuses){
			customer.getBonusCard().setBalance(customer.getBonusCard().getBalance() - needBonuses);
			System.out.println("Your purchase is free");
		} else{
			System.out.println("Not enough bonuses! Сhoose another form of payment");
		}
	}

}
