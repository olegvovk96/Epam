package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		List<Train> trains = new ArrayList<>();
		
		trains.add(new Train.Builder()
		      .freeSeats(4)
		      .numberTrain("142Ш")
		      .station(new Station.Builder()
				 .dateFrom(new GregorianCalendar[] {new GregorianCalendar(2017, Calendar.DECEMBER, 31, 16, 20), new GregorianCalendar(2017, Calendar.DECEMBER, 31, 16, 33),
						 new GregorianCalendar(2017, Calendar.DECEMBER, 31, 17, 39), new GregorianCalendar(2017, Calendar.DECEMBER, 31, 18, 1),
						 new GregorianCalendar(2017, Calendar.DECEMBER, 31, 18, 20), new GregorianCalendar(2017, Calendar.DECEMBER, 31, 18, 48),
						 new GregorianCalendar(2017, Calendar.JANUARY, 1, 2, 38), new GregorianCalendar(2017, Calendar.JANUARY, 1, 3, 20),
						 new GregorianCalendar(2017, Calendar.JANUARY, 1, 4, 29)})
				 .dateTo(new GregorianCalendar[] {new GregorianCalendar(2017, Calendar.DECEMBER, 31, 16, 31), new GregorianCalendar(2017, Calendar.DECEMBER, 31, 17, 37),
						 new GregorianCalendar(2017, Calendar.DECEMBER, 31, 17, 57), new GregorianCalendar(2017, Calendar.DECEMBER, 31, 18, 13),
						 new GregorianCalendar(2017, Calendar.DECEMBER, 31, 18, 45), new GregorianCalendar(2017, Calendar.JANUARY, 1, 2, 18),
						 new GregorianCalendar(2017, Calendar.JANUARY, 1, 3, 18), new GregorianCalendar(2017, Calendar.JANUARY, 1, 4, 27),
						 new GregorianCalendar(2017, Calendar.JANUARY, 1, 4, 46)})
				 .location(new String[] {"Львів", "Підзамче", "Соснівка", "Червоноград", "Сокаль", 
				            		   	"Іваничі", "Коростень", "Малин", "Святошино", "Київ"}).build())
			  .build());
		
		
		trains.add(new Train.Builder()
	          .freeSeats(0)
	          .numberTrain("668К")
	          .station(new Station.Builder()
	            .dateFrom(new GregorianCalendar[] {new GregorianCalendar(2017, Calendar.JANUARY, 3, 1, 1), new GregorianCalendar(2017, Calendar.JANUARY, 3, 2, 40), 
	            		new GregorianCalendar(2017, Calendar.JANUARY, 3, 3, 19), new GregorianCalendar(2017, Calendar.JANUARY, 3, 3, 35)})
	            .dateTo(new GregorianCalendar[] {new GregorianCalendar(2017, Calendar.JANUARY, 3, 2, 38), new GregorianCalendar(2017, Calendar.JANUARY, 3, 3, 17),
	            		new GregorianCalendar(2017, Calendar.JANUARY, 3, 3, 33), new GregorianCalendar(2017, Calendar.JANUARY, 3, 4, 12)})
	            .location(new String[] {"Львів", "Ходорів", "Бурштин", "Галич", "Івано-Франківськ"}).build())
	           .build());
				             
		
		boolean isRun = true;
		Scanner sc = new Scanner(System.in);
		
		while(isRun){
			System.out.println("Enter 0 to exit");
			System.out.println("Enter 1 to show all trains");		
			System.out.println("Enter 2 to show what trains get to specific station");
			System.out.println("Enter 3 to show what trains go after given time");
			System.out.println("Enter 4 to search trains in station where are free seats");
			System.out.println("Enter 5 to show if trains go in even or odd day");
			System.out.println("Enter 6 to show trains what go on Saturdays");
			System.out.println("Enter 7 to show what trains go per all days except Sunday");
				
			
			switch (sc.next()) {
			case "1": {
				Iterator<Train> iterator = trains.iterator();
				while (iterator.hasNext()) {
					Train train = iterator.next();
					System.out.println(train);
				}
				break;
			}				
			case "2":{		
				Iterator<Train> iterator = trains.iterator();
				Station.methodOfFindingTrainsByLocations(trains, sc, iterator);
				break;
			}
			case "3":{		
				Iterator<Train> iterator = trains.iterator();
				Station.sendingTrainsAfterGivenTime(trains, sc, iterator);
				break;
			}
			
			case "4":{		
				Iterator<Train> iterator = trains.iterator();
				Station.searchTrainsPerFreeSeatsAndLocation(trains, sc, iterator);
				break;
			}
			case "5":{
				Iterator<Train> iterator = trains.iterator();
				Station.verifyWhatTrainsGoInEvenAndOddDays(trains, iterator);
				break;
			}
			case "6":{
				Iterator<Train> iterator = trains.iterator();
				Station.printTrainsOnSaturdays(trains, iterator);
				break;
			}
			case "7":{
				Iterator<Train> iterator = trains.iterator();
				Station.printTrainsPerAllDaysExceptSunday(trains, iterator);
				break;
			}
			
			default:
				sc.close();
				isRun = false;
				break;
			}
		}
	}

}
