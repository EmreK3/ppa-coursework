public class Player {
	private String name;
	private int lives;
	private Room currentRoom;

	public Player(String name, int lives, Room currentRoom) {
		this.name = name;
		this.lives = lives;
		this.currentRoom = currentRoom;
	}

	public boolean move(Room room) {
		boolean correctRoom;
		if(room.getContainsMonster() == true) {
			correctRoom = false;
			lives -= 1;
			System.out.println("---------------------");
			System.out.println("You've walked into the Monster's dungeon!");
			System.out.println("You rush back out but take some damage in the process, you lose a life.");
		} else {
			correctRoom = true;
			currentRoom = room;
		}
		return correctRoom;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getLives() {
		return lives;
	}

	public Room getBlueDoorRoom() {
		return currentRoom.getBlueDoorRoom();
	}

	public Room getRedDoorRoom() {
		return currentRoom.getRedDoorRoom();
	}

	public String getCurrentRoomName() {
		return currentRoom.getRoomName();
	}

	public boolean getIsFinalRoom() {
		return currentRoom.getIsFinalRoom();
	}
}