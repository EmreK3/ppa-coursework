package assesment;

// Import Map and TreeMap libraries
import java.util.Map;
import java.util.TreeMap;

public class Banker extends Person {
	Map<Relative,Integer> map = new TreeMap<Relative,Integer>();
	private int friendliness;
	private Relative current;
	
	// Constructor that utilises the Person constructor with an extra variable, friendliness
	
	public Banker(String name, int distance, int friendliness) {
		super(name, distance);
		this.friendliness = friendliness;
	}
	
	/**
	 * Method begins by setting the boolean fullyMatched to false, this booelan
	 * will stay false until the best relative (in terms of distance and friendliness) is found.
	 * This is also important as the while loop will keep looping until the best match is found
	 * Inside the while loop we set a variable to infinity, as after this we loop through the 
	 * TreeMap and for each loop, if the specific Relative's distance is shorter than the
	 * variable that (at the beginning) holds infinity, then this variable is set to that Relative's
	 * distance.
	 * Once the method finds the closest Relative, it checks the Relative's friendliness. If this value
	 * is less than Mr Poe's friendliness, then this Relative is rejected and removed from the list;
	 * if it is greater than Mr Poe's, then this Relative is accepted and is the best match.
	 * @return Relative, returns the relative that is the best match
	 */
	
	public Relative findBestMatch() {
		boolean fullyMatched = false;
		
		int friendliness = 0;
		
		while(fullyMatched == false) {
			double inf = Double.POSITIVE_INFINITY;
			int shortest = (int)inf;
			
			for(Map.Entry<Relative,Integer> entry : map.entrySet()) {
				Relative placeholder = entry.getKey(); // to not break law of Demeter on line 27
				if(placeholder.getDistance() < shortest) {
					shortest = placeholder.getDistance();
					current = placeholder;
					friendliness = entry.getValue();
				}
			}
			System.out.println("Mr Poe finds that the next closest relative is: " + current.getName() + " (" + current.getDistance() + ").");
			if(friendliness >= this.friendliness) {
				fullyMatched = true;
				System.out.println("Mr Poe has established that this relative has a suitble level of friendliness (" + friendliness + ") and therefore is happy with the match.");
			} else {
				System.out.println("Mr Poe has established that this relative does not have a suitble level of friendliness (" + friendliness + ") and therefore is not happy with the match.");
				map.remove(current);
			}
		}
		
		return current;
	}
	
	// A method to add to the TreeMap
	
	public void addToList(Relative Relative, int friendliness) {
		map.put(Relative, friendliness);
	}
	
	// 2 getters 
	
	public Map<Relative,Integer> getMap() {
		return map;
	}
		
	public int getFriendliness() {
		return friendliness;
	}
}
