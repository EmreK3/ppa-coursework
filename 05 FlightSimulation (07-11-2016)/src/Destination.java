public class Destination {
	private String name;
	private Coordinates coordinates;

	public Destination(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}
}