import java.util.ArrayList;

public class Board {
	private ArrayList<Battleship> ships;
	
	/**
	 * Constructor initialises the ships ArrayList
	 * and adds all five ships to it in order.
	 */
	
	public Board() {
		ships = new ArrayList<Battleship>();
		ships.add(new Battleship(0));
		ships.add(new Cruiser(1));
		ships.add(new Cruiser(2));
		ships.add(new Frigate(3));
		ships.add(new Minesweeper(4));
	}
	
	/**
	 * Overrides default toString method to
	 * display all boxes for the 5x5 grid.
	 */
	
	public String toString() {
		String output = "   0   1   2   3   4 \n";
		
		for(int i = 0; i < ships.size(); i++) {
			output = output + i + " " + ships.get(i) + "\n";
		}
		return output;
	}
	
	/**
	 * This method checks which ship the user is referring
	 * to using the row input. It then calls the hit method
	 * on the relevant shit. If either the row or column values
	 * are greater than 4, then the program returns false.
	 * Else, the output is dependent on whatever the result is
	 * from the hit method.
	 * @param row, row number
	 * @param column, column number
	 * @return boolean, true or false; depending on hit or not. 
	 */
	
	public boolean hit(int row, int column) {
		if(row > 4 || column > 4) {
			System.out.println("Out of bounds, please pick numbers between 0 and 4!");
			return false;
		} else if(ships.get(row).hit(row, column)){
			System.out.println("Hit!");
			return true;
		} else {
			System.out.println("Miss!");
			return false;
		}
	}
	
	// Getter, returns the ships ArrayList
	
	public ArrayList<Battleship> getShips() {
		return ships;
	}
}
