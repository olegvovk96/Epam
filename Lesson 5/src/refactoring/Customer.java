package refactoring;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {			
			Rental each = (Rental) rentals.nextElement();			
			
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
			
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}
	
	private double getTotalCharge(){
		double result = 0;
		Enumeration rentals = _rentals.elements();
		
		while (rentals.hasMoreElements()) {			
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints(){
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		
		while (rentals.hasMoreElements()) {	
			Rental each = (Rental) rentals.nextElement();			
			frequentRenterPoints += each.getFrequentRenterPoints();	
		}
		return frequentRenterPoints;
	}
	
	public String htmlStatement(){
		Enumeration rentals = _rentals.elements();
		String result = "<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n";
		while (rentals.hasMoreElements()) {			
			Rental each = (Rental) rentals.nextElement();
			
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "<br>\n";
						
		}			
		// add footer lines
		result += "<p>Amount owed is <em>" + String.valueOf(getTotalCharge()) + "<em></p>\n";
		result += "You earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em> frequent renter points<p>";
		return result;
	}
}
