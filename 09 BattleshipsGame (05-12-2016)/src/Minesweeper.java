public class Minesweeper extends Battleship {
	// Uses constructor in Battleship (parent class)
	public Minesweeper(int row) {
		super(row, 2);
	}
	
	/**
	 * This hit method overrides the hit method already
	 * in the parent class Battleship. This method adds
	 * a 50% chance of the ship part not being destroyed
	 * given that it is hit. This is done by Math.random()
	 * which generates a number between 0 and 1.
	 * @param row, row number.
	 * @param column, column number
	 * @return boolean, true or false; depending on hit or not.
	 */
	
	public boolean hit(int row, int column) {
		double random = Math.random();
		boolean result = false;
		
		if(random < 0.5 && super.hit(row, column)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}