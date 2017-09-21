public class Room {
	private String name;
	private Room blueDoorRoom;
	private Room redDoorRoom;
	private boolean containsMonster;
	private boolean isFinalRoom;

	public Room(String name, boolean containsMonster, boolean isFinalRoom) {
		this.name = name;
		this.containsMonster = containsMonster;
		this.isFinalRoom = isFinalRoom;
	}

	public Room(String name, Room blueDoorRoom, Room redDoorRoom) {
		this.name = name;
		this.blueDoorRoom = blueDoorRoom;
		this.redDoorRoom = redDoorRoom;
	}

	public String getRoomName() {
		return name;
	}

	public Room getBlueDoorRoom() {
		return blueDoorRoom;
	}

	public Room getRedDoorRoom() {
		return redDoorRoom;
	}

	public boolean getContainsMonster() {
		return containsMonster;
	}

	public boolean getIsFinalRoom() {
		return isFinalRoom;
	}
}