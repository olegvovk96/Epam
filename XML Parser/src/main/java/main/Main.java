package main;

import java.io.File;
import java.util.List;

import model.Bank;
import parser.dom.DOMUserParser;
import parser.sax.SAXUserParser;
import parser.stax.StAXReader;

public class Main {

	public static void main(String[] args) {
		File xml = new File("src/main/resources/bankXML.xml");
		printBanks(SAXUserParser.parseBank(xml), "SAX");
		printBanks(DOMUserParser.getBanks(xml), "DOM");
		printBanks(StAXReader.parseBank(xml), "StAX");
		
	}
	
	private static void printBanks(List<Bank> banks, String parseName){
		System.out.println(parseName);
		for (Bank bank : banks) {
			System.out.println(bank);
		}
	}

}
