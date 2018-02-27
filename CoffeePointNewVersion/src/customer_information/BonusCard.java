package customer_information;

public class BonusCard {
	int balance;
	
	int bonusToMoney;
	
	
	public BonusCard(int balance) {
		this.balance = balance;
		this.bonusToMoney = 1000;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBonusToMoney() {
		return bonusToMoney;
	}

	public void setBonusToMoney(int bonusToMoney) {
		this.bonusToMoney = bonusToMoney;
	}

	@Override
	public String toString() {
		return "balance = " + balance + ", bonusToMoney = " + bonusToMoney / 100 + "." + bonusToMoney % 100 + " грн.";
	}
	
}
