package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Station {
		
	private GregorianCalendar[] dateFrom; // array where are sending trains every station
	
	private GregorianCalendar[] dateTo;
	
	private String location[];

	
	public GregorianCalendar[] getDateTo() {
		return dateTo;
	}

	public void setDateTo(GregorianCalendar[] dateTo) {
		this.dateTo = dateTo;
	}

	
	public static void methodOfFindingTrainsByLocations(List<Train> trains, Scanner sc, Iterator<Train> iterator){
		int indexStartLocation = 0;
		System.out.println("Enter initial location");
		String stationStart = sc.next();
		System.out.println("Enter ultimate location");
		String stationFinish = sc.next();
		while (iterator.hasNext()) {
			Train train = (Train) iterator.next();
			for (int i = 0; i < train.getStation().location.length; i++) {
				if(train.getStation().location[i].equals(stationStart)){
					indexStartLocation = i;
				}
				if(train.getStation().location[i].equals(stationFinish) && i > indexStartLocation){
					System.out.println(train);
				}
			}
		}
	}
	
	public static boolean isDateValid(String date, String format){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	public static void sendingTrainsAfterGivenTime(List<Train> trains, Scanner sc, Iterator<Train> iterator){
		int countTime = 0;
		System.out.println("Enter time using this template - HH:mm(hours:minutes(00-23, 00-59))");
		String time = sc.next();
		int[] hour = new int[2];
		int j = 0;
		String str="";
		if(isDateValid(time, "HH:mm")){
			for (int i = 0; i < time.length(); i++) {
				if(time.charAt(i) != ':'){
					str+= time.charAt(i);
				} else{		
					hour[j] = Integer.valueOf(str);
					j++;
					str = "";
				}			
			}
			while (iterator.hasNext()) {
				Train train = (Train) iterator.next();
				for(int i = 0; i < train.getStation().dateFrom.length; i++){
					if(train.getStation().dateFrom[i].get(Calendar.HOUR_OF_DAY) >= hour[0] &&
							train.getStation().dateFrom[i].get(Calendar.MINUTE) >= hour[1]){
						countTime++;
					}				
				}
				if(countTime > 0){
					System.out.println(train.getNumberTrain());
				}
				countTime = 0;
			}
		} else{
			System.out.println("Number is invalid");
		}
	}
	
	public static void searchTrainsPerFreeSeatsAndLocation(List<Train> trains, Scanner sc, Iterator<Train> iterator){
		System.out.println("Enter location, or its first letters for search:");
		String strLocation = sc.next();
		while (iterator.hasNext()) {
			Train train = (Train) iterator.next();
			for(int i = 0; i < train.getStation().location.length; i++){
				if(train.getFreeSeats() > 0 &&
						train.getStation().location[i].contains(strLocation)){
					System.out.println(train);
				}
			}
		}
	}
	
	public static void verifyWhatTrainsGoInEvenAndOddDays(List<Train> trains, Iterator<Train> iterator){
		while (iterator.hasNext()) {
			Train train = (Train) iterator.next();
				if(train.getStation().dateFrom[0].get(Calendar.DAY_OF_MONTH) % 2 == 0){
					System.out.println("In Even day = " + train.getNumberTrain());
				} else{
					System.out.println("In Odd day = " + train.getNumberTrain());
				}
		}
	}
	
	public static void printTrainsOnSaturdays(List<Train> trains, Iterator<Train> iterator){
		while (iterator.hasNext()) {
			Train train = (Train) iterator.next();
				if(train.getStation().dateFrom[0].get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
					System.out.println(train);
				}
		}
	}
	
	public static void printTrainsPerAllDaysExceptSunday(List<Train> trains, Iterator<Train> iterator){
		while (iterator.hasNext()) {
			Train train = (Train) iterator.next();
				if(train.getStation().dateFrom[0].get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
					System.out.println(train);
				}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (!Arrays.equals(location, other.location))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Station [location="+ Arrays.toString(location) + "]";
	}


	public static class Builder{
		
		private final Station station = new Station();
		
		public Builder dateFrom(GregorianCalendar[] dateFrom){
			station.dateFrom = dateFrom;
			return this;
		}
		
		public Builder dateTo(GregorianCalendar[] dateTo){
			station.dateTo = dateTo;
			return this;
		}
		
		public Builder location(String location[]){
			station.location = location;
			return this;
		}
		
		public Station build(){
			return station;
		}
	}
}
