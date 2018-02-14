package parser.dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Bank;
import model.DepositType;

public class DOMReader {
	public List<Bank> readDoc(Document doc){
		doc.getDocumentElement().normalize();
		List<Bank> banks = new ArrayList<>();
		NodeList nList = doc.getElementsByTagName("bank");
		for (int i = 0; i < nList.getLength(); i++) {
			Bank bank = new Bank();
			List<DepositType> depositTypes;
			Node node = nList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) node;
				bank.setId(Integer.valueOf(element.getAttribute("id")));
				bank.setName(element.getElementsByTagName("name").item(0).getTextContent());
				bank.setCountry(element.getElementsByTagName("country").item(0).getTextContent());
				depositTypes = getTypes(element.getElementsByTagName("types"));
				bank.setDepositor(element.getElementsByTagName("depositor").item(0).getTextContent());
				bank.setAccountId(Integer.valueOf(element.getElementsByTagName("accountId").item(0).getTextContent()));
				bank.setDepositAmount(Integer.valueOf(element.getElementsByTagName("depositAmount").item(0).getTextContent()));
				bank.setCurrency(element.getElementsByTagName("currency").item(0).getTextContent());
				bank.setProfitability(Integer.valueOf(element.getElementsByTagName("profitability").item(0).getTextContent()));
				bank.setNumberMonths(Integer.valueOf(element.getElementsByTagName("numberMonths").item(0).getTextContent()));
				
				bank.setTypes(depositTypes);
				banks.add(bank);
			}
		}
		return banks;
	}
	
	private List<DepositType> getTypes(NodeList nList){
		List<DepositType> types = new ArrayList<>();
		if(nList.item(0).getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) nList.item(0);
            NodeList nodeList = element.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element) node;
                    types.add(new DepositType(el.getTextContent()));
                }
            }
		}
		return types;
	}
}
