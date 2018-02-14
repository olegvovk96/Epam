package parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Bank;
import model.DepositType;

public class SAXUserHandler extends DefaultHandler{

	private List<Bank> banks = new ArrayList<>();
	private Bank bank = null;
	private List<DepositType> types = null;
	
	
	private boolean bName;
	private boolean bCountry;
	private boolean bTypes;
	private boolean bType;
	private boolean bDepositor;
	private boolean bAccountId;
	private boolean bDepositAmount;
	private boolean bCurrency;
	private boolean bProfitability;
	private boolean bNumberMonths;
	
	public List<Bank> getListBanks(){
		return this.banks;
	}
	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("bank")){
			String id = attributes.getValue("id");
			bank = new Bank();
			bank.setId(Integer.valueOf(id));
		} 
		else if(qName.equalsIgnoreCase("name"))
			bName = true;
		else if(qName.equalsIgnoreCase("country"))
			bCountry = true;
		else if(qName.equalsIgnoreCase("types"))
			bTypes = true;
		else if(qName.equalsIgnoreCase("type"))
			bType = true;
		else if(qName.equalsIgnoreCase("depositor"))
			bDepositor = true;
		else if(qName.equalsIgnoreCase("accountId"))
			bAccountId = true;
		else if(qName.equalsIgnoreCase("depositAmount"))
			bDepositAmount = true;
		else if(qName.equalsIgnoreCase("currency"))
			bCurrency = true;
		else if(qName.equalsIgnoreCase("profitability"))
			bProfitability = true;
		else if(qName.equalsIgnoreCase("numberMonths"))
			bNumberMonths = true;			
	}


	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("bank"))
			banks.add(bank);
	}


	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(bName){
			bank.setName(new String(ch, start, length));
			bName = false;
		} else if(bCountry){
			bank.setCountry(new String(ch, start, length));
			bCountry = false;
		} else if(bTypes){
			types = new ArrayList<>();
			bTypes = false;
		} else if(bType){
			DepositType depositType = new DepositType();
			depositType.setType(new String(ch, start, length));
			types.add(depositType);
			bank.setTypes(types);
			bType = false;
		} else if(bDepositor){
			bank.setDepositor(new String(ch, start, length));
			bDepositor = false;
		} else if(bAccountId){
			bank.setAccountId(Integer.valueOf(new String(ch, start, length)));
			bAccountId = false;
		} else if(bDepositAmount){
			bank.setDepositAmount(Integer.valueOf(new String(ch, start, length)));
			bDepositAmount = false;
		} else if(bCurrency){
			bank.setCurrency(new String(ch, start, length));
			bCurrency = false;
		} else if(bProfitability){
			bank.setProfitability(Integer.valueOf(new String(ch, start, length)));
			bProfitability = false;
		} else if(bNumberMonths){
			bank.setNumberMonths(Integer.valueOf(new String(ch, start, length)));
			bNumberMonths = false;
		}
	}
	
}
