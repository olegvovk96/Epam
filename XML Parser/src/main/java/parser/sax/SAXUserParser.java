package parser.sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.SAXException;

import model.Bank;

public class SAXUserParser {
	
	private static SAXParserFactory factory = SAXParserFactory.newInstance();
	
	public static List<Bank> parseBank(File xml){
		List<Bank> banks = new ArrayList<>();
		try {
			SAXParser saxParser = factory.newSAXParser();
			SAXUserHandler saxUserHandler = new SAXUserHandler();
			saxParser.parse(xml, saxUserHandler);
			banks = saxUserHandler.getListBanks();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return banks;
	}
}
