public class RaceTrack {
	private int averageLapTime;
	private boolean isRaining;

	/**
	 * A method of type int that determines the race leader
	 * by using if statements and conditionals to compare total times.
	 */

	public int determineRaceLeader(Car car1, Car car2, Car car3) {
		int isFirstPlace;
		
		if(car1.getTotalTime() < car2.getTotalTime() && car1.getTotalTime() < car3.getTotalTime()) {
			isFirstPlace = car1.printCarId();
		} 
		else if(car2.getTotalTime() < car1.getTotalTime() && car2.getTotalTime() < car3.getTotalTime()) {
			isFirstPlace = car2.printCarId();
		} 
		else {
			isFirstPlace = car3.printCarId();
		}
		return isFirstPlace;
	}

	// Two setters to set average lap time and if it is raining or not via the main method

	public void setAverageLapTime(int averageLapTime) {
		this.averageLapTime = averageLapTime;
	}

	public void setIsRaining(boolean isRaining) {
		this.isRaining = isRaining;
	}

	// Two getters to use in other classes

	public int getAverageLapTime() {
		return averageLapTime;
	}

	public boolean getIsRaining() {
		return isRaining;
	}
}