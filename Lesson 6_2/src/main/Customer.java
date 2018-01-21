package main;

public class Customer {
	private String firstName;
	
	private String lastName;
	
	private int cash;
	
	private int balanceCreditCard;
	
	private PaymentType payment;
	
	private BonusCard bonusCard;

	public Customer(String firstName, String lastName, BonusCard bonusCard, 
			       int cash, int balanceCreditCard, PaymentType payment) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bonusCard = bonusCard;
		this.cash = cash;
		this.balanceCreditCard = balanceCreditCard;
		this.payment = payment;
	}
	
	public void showBonuses(){
		System.out.println(getBonusCard().getBonuses());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BonusCard getBonusCard() {
		return bonusCard;
	}

	public void setBonusCard(BonusCard bonusCard) {
		this.bonusCard = bonusCard;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getBalanceCreditCard() {
		return balanceCreditCard;
	}

	public void setBalanceCreditCard(int balanceCreditCard) {
		this.balanceCreditCard = balanceCreditCard;
	}

	public PaymentType getPayment() {
		return payment;
	}

	public void setPayment(PaymentType payment) {
		this.payment = payment;
	}

	
}
