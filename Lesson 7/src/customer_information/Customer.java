package customer_information;


public class Customer {
	private String firstName;
	
	private String lastName;
	
	private Cash cash;
	
	private CreditCard card;
	
	private BonusCard bonusCard;
	
	

	public Customer(String firstName, String lastName, Cash cash, CreditCard card, BonusCard bonusCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cash = cash;
		this.card = card;
		this.bonusCard = bonusCard;
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

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public BonusCard getBonusCard() {
		return bonusCard;
	}

	public void setBonusCard(BonusCard bonusCard) {
		this.bonusCard = bonusCard;
	}

	@Override
	public String toString() {
		return "Customer [firstName = " + firstName + ", lastName = " + lastName + ", Cash: " + cash + ", creditCard: " + card
				+ ",  bonusCard: " + bonusCard + "]";
	}
	
	
}
