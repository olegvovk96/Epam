package customer_information;

public class CreditCard {
	
	private String numberCard;
	
	private int cvv;
	
	private int balance;

	public CreditCard(int balance){
		this.balance = balance;
	}

	
	public String getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "balance = " + balance / 100 + "." + balance % 100 + " грн.";
	}

	
	
}
