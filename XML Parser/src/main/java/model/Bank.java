package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private int id;
	
	private String name;
	
	private String country;
	
	private List<DepositType> types = new ArrayList<>();
	
	private String depositor;
	
	private int accountId;
	
	private int depositAmount;
	
	private String currency;
	
	private int profitability;
	
	private int numberMonths;


	
	public Bank() {
	}


	public Bank(int id, String name, String country, List<DepositType> types, String depositor, int accountId,
			int depositAmount, String currency, int profitability, int numberMonths) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.types = types;
		this.depositor = depositor;
		this.accountId = accountId;
		this.depositAmount = depositAmount;
		this.currency = currency;
		this.profitability = profitability;
		this.numberMonths = numberMonths;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public List<DepositType> getTypes() {
		return types;
	}


	public void setTypes(List<DepositType> types) {
		this.types = types;
	}


	public String getDepositor() {
		return depositor;
	}


	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public int getDepositAmount() {
		return depositAmount;
	}


	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public int getProfitability() {
		return profitability;
	}


	public void setProfitability(int profitability) {
		this.profitability = profitability;
	}


	public int getNumberMonths() {
		return numberMonths;
	}


	public void setNumberMonths(int numberMonths) {
		this.numberMonths = numberMonths;
	}


	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", country=" + country + ", types=" + types + ", depositor="
				+ depositor + ", accountId=" + accountId + ", depositAmount=" + depositAmount + ", currency=" + currency
				+ ", profitability=" + profitability + ", numberMonths=" + numberMonths + "]";
	}
	
}
