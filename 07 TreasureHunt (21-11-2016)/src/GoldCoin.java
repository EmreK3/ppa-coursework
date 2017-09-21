public class GoldCoin {
	private static int coinNumber;
	private int generateNumber;
	
	public GoldCoin() {
		generateNumber = coinNumber++;
	}

	public int getCoinNumber() {	
		return generateNumber;
	}
}