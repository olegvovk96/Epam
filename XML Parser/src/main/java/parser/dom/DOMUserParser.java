package parser.dom;

import java.io.File;
import java.util.List;

import org.w3c.dom.Document;

import model.Bank;

public class DOMUserParser {
	public static List<Bank> getBanks(File xml){
		DOMDocumentCreator domDocumentCreator = new DOMDocumentCreator(xml);
		Document doc = domDocumentCreator.getDocument();
		DOMReader domReader = new DOMReader();
		return domReader.readDoc(doc);
	}
}
