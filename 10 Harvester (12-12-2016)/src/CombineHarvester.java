public class CombineHarvester extends Harvester {
	private int length;
	
	/**
	 * A constructor that uses the parent class's constructor
	 * but also includes length, unique to this class.
	 */
	
	public CombineHarvester(int fuelTankSize, int topSpeed, int length) {
		super(fuelTankSize, topSpeed);
		this.length = length;
	}
	
	// Overrides the harvestingCapacity method already in Harvester
	
	public int harvestingCapacity() {
		return super.harvestingCapacity() * length;
	}
}
