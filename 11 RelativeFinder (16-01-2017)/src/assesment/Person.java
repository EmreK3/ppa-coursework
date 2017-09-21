package assesment;
	
public class Person implements Comparable<Person> {
	private String name;
	private int distance;
	
	// Constructor for Person
	
	public Person(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
	
	/** 
	 * Overrides the compareTo method
	 */
	
	@Override
	public int compareTo(Person person) {
		return name.compareTo(person.name);
	}
	
	/**
	 * Overrides the toString method
	 * so that it displays a name and a
	 * distance when the object is printed
	 */
	
	@Override
	public String toString() {
		return name + ", distance: " + distance;
	}
	
	// Two getters 
	
	public String getName() {
		return name;
	}
	
	public int getDistance() {
		return distance;
	}
}
