public class GoldCoin {
	private static int generateNumber;
	private int coinNumber;
	
	/**
	 * toString method, which is called when I print an 
	 * object of type GoldCoin
	 */
	
	public String toString() {
		return "Coin " + coinNumber;
	}
	
	// Constructor that assigns a coin number to each GoldCoin object
	
	public GoldCoin() {
		coinNumber = generateNumber++;
	}
	
	// Getter
	
	public int getCoinNumber() {
		return coinNumber;
	}
}
