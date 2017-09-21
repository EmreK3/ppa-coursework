public class Car {
	private int id;
	private int fuel;
	private int lowFuelBoost;
	private int highFuelSlowdown;
	private int fuelConsumptionPerLap;
	private int pitStopTime;
	private int rainSlowdown;
	private int totalTime;

	/**
	 * Constructor that allows me to set all the private variables
	 * by creating an object in the main method.
	 */

	public Car(int id, int fuel, int lowFuelBoost, int highFuelSlowdown, int fuelConsumptionPerLap, int pitStopTime, int rainSlowdown, int totalTime) {
		this.id = id;
		this.fuel = fuel;
		this.lowFuelBoost = lowFuelBoost;
		this.highFuelSlowdown = highFuelSlowdown;
		this.fuelConsumptionPerLap = fuelConsumptionPerLap;
		this.pitStopTime = pitStopTime;
		this.rainSlowdown = rainSlowdown;
		this.totalTime = totalTime;
	}

	/**
	 * Method of type int that makes the cars complete a lap of the course
	 * with certain conditions that calculates the total time taken
	 */

	public int completeLap(RaceTrack x) {
		int sumOfLapTimes = totalTime;
		totalTime = x.getAverageLapTime();

		if(fuel > 50) {
			totalTime += highFuelSlowdown;
		} else {
			totalTime -= lowFuelBoost;
		}

		if(x.getIsRaining() == true) {
			totalTime += rainSlowdown;
		}

		fuel -= fuelConsumptionPerLap;

		if(fuel < fuelConsumptionPerLap) {
			totalTime += pitStopTime;
			fuel = 100;
		}

		return totalTime += sumOfLapTimes;
	}

	// Two getters for use in other classes
	
	public int getTotalTime() {
		return totalTime;
	}

	public int printCarId() {
		return id;
	}
}