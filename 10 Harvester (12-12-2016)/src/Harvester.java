public class Harvester {
	private int fuelTankSize;
	private int topSpeed;
	
	// Constructor to specify fuelTankSize and topSpeed
	
	public Harvester(int fuelTankSize, int topSpeed) {
		this.fuelTankSize = fuelTankSize;
		this.topSpeed = topSpeed;
	}
	
	// A method that calculates how many fields it can harvest.
	
	public int harvestingCapacity() {
		return fuelTankSize + topSpeed;
	}
}
