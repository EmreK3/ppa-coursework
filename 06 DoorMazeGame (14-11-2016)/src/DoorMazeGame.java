import java.util.Scanner;

public class DoorMazeGame {
	public static void main(String[] args) {
		Room monsterRoom = new Room("The Monster Room", true, false);
		Room room6 = new Room("Pathway 6", false, true);
		Room room5 = new Room("Pathway 5", monsterRoom, room6);
		Room room4 = new Room("Pathway 4", room5, monsterRoom);
		Room room3 = new Room("Pathway 3", room4, monsterRoom);
		Room room2 = new Room("Pathway 2", room3, monsterRoom);
		Room room1 = new Room("Pathway 1", monsterRoom, room2);

		Player player1 = new Player("Player 1", 2, room1);

		System.out.println("Introductory message");
		System.out.println("Enter your name:");
		Scanner userInputForName = new Scanner(System.in);
		player1.setName(userInputForName.nextLine());
		userInputForName.close();
		
		while(player1.getLives() != 0 && player1.getIsFinalRoom() == false) {
			System.out.println("---------------------");
			System.out.println("Player name: " + player1.getName());
			System.out.println("Lives left: " + player1.getLives());
			System.out.println("Current room: " + player1.getCurrentRoomName());
			
			System.out.println("Pick a door: blue or red.");
			Scanner userPickRoom = new Scanner(System.in);
			String pickRoom = userPickRoom.nextLine();

			while(!pickRoom.equals("blue") && !pickRoom.equals("red")) {
				System.out.println("---------------------");
				System.out.println("Unknown Command.");
				System.out.println("Available commands: blue, red");
				System.out.println("blue - picks the blue door");
				System.out.println("red - picks the red door");
				System.out.println("Pick again.");
				pickRoom = userPickRoom.nextLine();
				
				if(player1.getLives() == 0 || player1.getIsFinalRoom()) {
					userPickRoom.close();
				}
			}
			
			if(pickRoom.equals("blue")) {
				player1.move(player1.getBlueDoorRoom());
			} else if(pickRoom.equals("red")) {
				player1.move(player1.getRedDoorRoom());
			}
		}
		
		/*if(player1.getLives() == 0 || player1.getIsFinalRoom() == true) {
			userPickRoom.close();
		}*/
		
		if(player1.getLives() == 0) {
			System.out.println("You have no more lives left, game over!");
		}

		if(player1.getIsFinalRoom() == true) {
			System.out.println("You have reached the final room, congratulations!");
		}
	}
}