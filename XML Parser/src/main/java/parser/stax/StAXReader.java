package parser.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import model.Bank;
import model.DepositType;

public class StAXReader {
	public static List<Bank> parseBank(File xml){
		List<Bank> banks = new ArrayList<>();
		Bank bank = null;
		List<DepositType> depositTypes = null;
		
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
				XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));
				
				while(xmlEventReader.hasNext()){
					XMLEvent event = xmlEventReader.nextEvent();
					if(event.isStartElement()){
						StartElement startElement = event.asStartElement();
						String qName = startElement.getName().getLocalPart();
						switch(qName){
							case "bank":
								bank = new Bank();
								Attribute attribute = startElement.getAttributeByName(new QName("id"));
								if(attribute != null){
									bank.setId(Integer.valueOf(attribute.getValue()));
								}
								break;
							case "name":
								event = xmlEventReader.nextEvent();
								assert bank != null;
								bank.setName(event.asCharacters().getData());
								break;
							case "country":
								event = xmlEventReader.nextEvent();
								assert bank != null;
								bank.setCountry(event.asCharacters().getData());
								break;
							case "depositor":
								event = xmlEventReader.nextEvent();
								assert bank != null;
								bank.setDepositor(event.asCharacters().getData());
								break;
							case "accountId":
								event = xmlEventReader.nextEvent();
								assert bank != null;
								bank.setAccountId(Integer.valueOf(event.asCharacters().getData()));
								break;
							case "depositAmount":
								event = xmlEventReader.nextEvent();
								assert bank != null;
								bank.setDepositAmount(Integer.valueOf(event.asCharacters().getData()));
								break;
							case "currency":
								event = xmlEventReader.nextEvent();
								assert bank != null;
								bank.setCurrency(event.asCharacters().getData());
								break;
							case "profitability":
								event = xmlEventReader.nextEvent();
								assert bank != null;
								bank.setProfitability(Integer.valueOf(event.asCharacters().getData()));
								break;
							case "numberMonths":
								event = xmlEventReader.nextEvent();
								assert bank != null;
								bank.setNumberMonths(Integer.valueOf(event.asCharacters().getData()));
								break;
							case "types":
								event = xmlEventReader.nextEvent();
								depositTypes = new ArrayList<>();
								break;
							case "type":
								event = xmlEventReader.nextEvent();
	                            assert depositTypes != null;
	                            depositTypes.add(new DepositType(event.asCharacters().getData()));
	                            bank.setTypes(depositTypes);
	                            break;
						}
					}
					if(event.isEndElement()){
	                    EndElement endElement = event.asEndElement();
	                    if(endElement.getName().getLocalPart().equals("bank")){
	                        banks.add(bank);
	                    }
	                }
				}
		} catch (FileNotFoundException | XMLStreamException e) {
				e.printStackTrace();
		}
        return banks;
	}
}
