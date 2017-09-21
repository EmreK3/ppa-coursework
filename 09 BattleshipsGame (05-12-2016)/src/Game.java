import java.util.Collections;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		// Creates an object of the board.
		
		Board board = new Board();
		Scanner userInput = new Scanner(System.in);

		String crowdControl = "---------------------";
		
		// Main text that shows how many ships are left.
		
		System.out.println(Collections.frequency(board.getShips(), new Battleship(0)) + " Battleships");
		System.out.println(Collections.frequency(board.getShips(), new Cruiser(1)) + " Cruisers");
		System.out.println(Collections.frequency(board.getShips(), new Frigate(3)) + " Frigate");
		System.out.println(Collections.frequency(board.getShips(), new Minesweeper(4)) + " Minesweeper");
		System.out.println(crowdControl);
		System.out.println(board);
		
		System.out.println("Please enter in a row value and column value; seperated by a space. (Example: 1 1)");
		String input = userInput.nextLine();
		
		while(!input.equals("quit")) {
			
			// Splits inputed string in two, places them in the values Array
			
			String values[] = input.split(" ");
			
			// Converts the Strings in the values Array to Integers.
			
			int row = Integer.parseInt(values[0]);
			int column = Integer.parseInt(values[1]);
			
			board.hit(row, column);
			System.out.println(crowdControl);
			System.out.println(Collections.frequency(board.getShips(), new Battleship(0)) + " Battleships");
			System.out.println(Collections.frequency(board.getShips(), new Cruiser(1)) + " Cruisers");
			System.out.println(Collections.frequency(board.getShips(), new Frigate(3)) + " Frigate");
			System.out.println(Collections.frequency(board.getShips(), new Minesweeper(4)) + " Minesweeper");
			System.out.println(crowdControl);
			System.out.println(board);
			
			System.out.println("Please enter in a row value and column value; seperated by a space. (Example: 1 1)");
			values[0] = null;
			values[1] = null;
			
			// Takes userInput again
			
			input = userInput.nextLine();
		}
		
		if(input.equals("quit")) {
			userInput.close();
		}

	}
}