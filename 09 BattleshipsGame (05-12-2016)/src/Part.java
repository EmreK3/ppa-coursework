public class Part {
	private int column;
	private int row;
	private boolean destroyed;
	
	/**
	 * Constructor that sets the parts
	 * row and column, as well as initialising
	 * the destroyed boolean.
	 * @param row, row number.
	 * @param column, column number.
	 */
	
	public Part(int row, int column) {
		this.column = column;
		this.row = row;
		destroyed = false;
	}
	
	/**
	 * toString method that returns a box,
	 * with or without an X, depending on the
	 * value of the boolean destroyed
	 */
	
	public String toString() {
		if(destroyed) {
			return "[X]";
		} else {
			return "[ ]";
		}
	}
	
	/**
	 * Override the equals method in Object,
	 * checks if the columns and rows are the
	 * same value
	 */
	
	public boolean equals(Object part) {
		// Checks if the parameter is an instance of Part
		if (!(part instanceof Part)) return false;
		
		// Casts the parameter to type Part
		Part shipPart = (Part)part;
		
		if(shipPart.column == column && shipPart.row == row) {
			return true;
		} else {
			return false;
		}
	}
	
	// A getter and a setter for the destroyed boolean
	
	public boolean isDestroyed() {
		return destroyed;
	}
	
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
}
