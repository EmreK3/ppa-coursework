package simulation;

public class Runway {
	private int width,length,seconds;
	
	public Runway() {
		width = 10;
		length = 100;
		seconds = 0;
	}
	
	// Getters to access the private variables
	
	public int getWidth() {
		return width;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	// Method that increments seconds by one
	
	public void incrementSeconds() {
		seconds += 1;
	}
}
