public class Battleship {
	private Part[] parts;
	
	/**
	 * Uses the main constructor to set
	 * row number and ship length
	 * @param row, row number.
	 */
	
	public Battleship(int row) {
		this(row, 5);
	}
	
	/**
	 * Main constructor, runs a for-loop that fills
	 * the parts Array with parts with the same row.
	 * @param row, row number.
	 * @param arraysize, size of ship.
	 */
	
	public Battleship(int row, int arraysize) {
		parts = new Part[arraysize];
		for(int i = 0; i < parts.length; i++) {
			parts[i] = new Part(row,i);
		}
	}
	 
	/**
	 * toString method that prints out all boxes
	 * on the same line, for a given ship.
	 * If the ship's parts are less than 5 then
	 * it fills out the remaining boxes manually.
	 */
	
	public String toString() {
		String output = "";
		for(int i = 0; i < 5; i++) {
			if(i < parts.length) {
			output = output + parts[i] + " ";
			} else {
				output = output + "[ ] ";
			}
		}
		return output;
	}
	
	/**
	 * Takes two parameters, row and column, then proceeds
	 * to find out whether these values correspond to a part.
	 * If it does, it checks whether the part is already destroyed
	 * or not. Returns a boolean
	 * @param row, row number.
	 * @param column, column number.
	 * @return boolean, depending on hit or not.
	 */
	
	public boolean hit(int row, int column) {
		// Create a new part using parameters
		Part part = new Part(row,column);
		boolean hit = false;
		
		for(int i = 0; i < parts.length; i++) {
			if(parts[i].equals(part) && parts[i].isDestroyed() == false) {
				parts[i].setDestroyed(true);
				i = parts.length;
				hit = true;
			} else if(parts[i].equals(part) && parts[i].isDestroyed() == true) {
				i = parts.length;
				hit = true;
			} else if(!parts[i].equals(part)){
				hit = false;
			}
		}
		return hit;
	}
	
	/**
	 * Override the equals method in Object,
	 * Checks if the input is an instance of Battleship,
	 * if it is: the method checks if the inputed ship and
	 * the local ship is of the same length (i.e if their arrays
	 * are of the same size). If this is the case then the method
	 * runs through a for-loop that checks every single
	 * part of the ship to see if it is destroyed.
	 * If both have 5 destroyed parts, they are equal. If one
	 * of the ships has 5 destroyed parts and the other doesn't
	 * then they are not equal. Else, they are equal.
	 */
	
	public boolean equals(Object battleship) {
		if(!(battleship instanceof Battleship)) return false;
		
		Battleship ship = (Battleship)battleship;
		
		boolean equal = false;
		int local = 0;
		int parameter = 0;
		
		// checks if the ships are of same length
		if(ship.parts.length == parts.length) {
			// loop finds how many damanged parts consist inside this ship
			for(int i = 0; i < ship.parts.length; i++) {
				if(ship.parts[i].isDestroyed()) {
					parameter += 1;
				}
			}
			
			for(int i = 0; i < parts.length; i++) {
				if(parts[i].isDestroyed()) {
					local += 1;
				}
			}
			
			// conditions on whether they are equal or not
			if(local == parts.length && parameter == parts.length) {
				equal = true;
			} else if(local == parts.length || parameter == parts.length) {
				equal = false;
			} else {
				equal = true;
			}
			return equal;
		} else {
			equal = false;
		}
		return equal;
	}
}
