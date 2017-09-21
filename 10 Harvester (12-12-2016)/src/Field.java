public class Field {
	private Crop[] crops;
	private String type;
	private int value;
	
	/**
	 * This constructor initialises the crops array
	 * and sets its length to 10, then plants the crops
	 * using the plant() method, also in this class.
	 * @param type, type of crop.
	 * @param value, cost of crop.
	 */
	
	public Field(String type, int value) {
		crops = new Crop[10];
		this.type = type;
		this.value = value;
		plant();
	}
	
	/**
	 * Iterates through the crops Array and adds
	 * a new Crop with a certain type and value.
	 */
	
	public void plant() {
		for(int i = 0; i < crops.length; i++) {
			crops[i] = new Crop(type, value);
		}
	}
	
	/**
	 * Iterates through the crops Array and adds finds the sum
	 * of the 'value' for each crop in the Array.
	 * @return integer, total cost of all crops in one field.
	 */
	
	public int harvest() {
		int runningTotal = 0;
		
		for(int i = 0; i < crops.length; i++) {
			runningTotal += crops[i].getValue();
			crops[i] = null;
		}
		
		return runningTotal;
	}
}
