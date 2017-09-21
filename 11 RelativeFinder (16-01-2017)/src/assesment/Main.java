package assesment;

public class Main {

	public static void main(String[] args) {
		Banker poe = new Banker("Mr Poe", 0, 5); // Create Banker object

		poe.addToList(new Relative("Josephine", 100), 5);
		poe.addToList(new Relative("Olaf", 10), -10);
		poe.addToList(new Relative("Sir", 20), 0);
		poe.addToList(new Relative("Uncle Monty", 20), 10);
		
		System.out.println("Best match: " + poe.findBestMatch()); // Find best match.
	}

}
