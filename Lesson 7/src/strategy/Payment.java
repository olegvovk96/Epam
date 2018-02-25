package strategy;

import customer_information.Customer;

public interface Payment {
	
	void makePayment(int price, Customer customer);
	
    default void paymentDetails(Customer customer){}
}
