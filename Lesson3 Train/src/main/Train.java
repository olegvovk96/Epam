package main;

public class Train {

	private int freeSeats;
	
	private String numberTrain;
	
	private Station station;
		
	
	public String getNumberTrain() {
		return numberTrain;
	}

	public void setNumberTrain(String numberTrain) {
		this.numberTrain = numberTrain;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public int getFreeSeats() {
		return freeSeats;
	}

	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}



	@Override
	public String toString() {
		return "Train [freeSeats=" + freeSeats + ", numberTrain=" + numberTrain + ", station=" + station + "]";
	}




	public static class Builder{
		
		private final Train train = new Train();
		
		public Builder freeSeats(int freeSeats){
			train.freeSeats = freeSeats;
			return this;
		}
		
		public Builder numberTrain(String numberTrain){
			train.numberTrain = numberTrain;
			return this;
		}
		
		public Builder station(Station station){
			train.station = station;
			return this;
		}
		
		public Train build(){
			return train;
		}
		
	}
	
}
