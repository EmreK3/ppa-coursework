import java.util.ArrayList;

public class Farm {
	private ArrayList<Field> fields;
	private ArrayList<Harvester> harvesters;
	private int profit;
	
	// Constructor that initialises the fields and harvesters ArrayLists.
	
	public Farm() {
		fields = new ArrayList<Field>();
		harvesters = new ArrayList<Harvester>();
	}
	
	// Adds the integer value supplied as a parameter and adds it to 'profit'.
	
	public void profit(int profit) {
		this.profit += profit;
	}
	
	// A getter to access the value of profit.
	
	public int getProfit() {
		return profit;
	}
	
	/**
	 * If the total harvesting capacity is less than the amount of fields, 
	 * then only the same number of fields can be harvested, if it is greater than 
	 * or equal to the amount of fields, then all fields can be harvested.
	 */
	
	public void harvest() {
		int totalHarvestingCapacity = 0;
		
		// Checks for total harvesting capacity for all harvesters in the ArrayList
		
		for(int i = 0; i < harvesters.size(); i++) {
			totalHarvestingCapacity += harvesters.get(i).harvestingCapacity();
		}
	
		// Determines how many fields should be harvested.
		
		if(totalHarvestingCapacity < fields.size()) {
			for(int i = 0; i < totalHarvestingCapacity; i++) {
				profit(fields.get(i).harvest());
			}
		} else {
			for(int i = 0; i < fields.size(); i++) {
				profit(fields.get(i).harvest());
			}
		}
	}
	
	// Two add methods, which add to their respective ArrayLists.
	
	public void addHarvester(Harvester harvester) {
		harvesters.add(harvester);
	}
	
	public void addField(Field field) {
		fields.add(field);
	}
}
