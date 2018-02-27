package customer_information;

public class Cash {
	
	private int balance;
	
	public Cash(int balance){
		this.balance = balance;
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
