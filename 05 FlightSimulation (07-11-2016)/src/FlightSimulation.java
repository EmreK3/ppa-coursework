public class FlightSimulation {
	public static void main(String[] args) {
		Coordinates c1 = new Coordinates(60, 75);
		Destination destination1 = new Destination("Mumbai", c1);
		Coordinates c2 = new Coordinates(85, 95);
		Destination destination2 = new Destination("Stockholm", c2);
		Coordinates c3 = new Coordinates(130, 140);
		Destination destination3 = new Destination("New", c3);

		Coordinates planeStart = new Coordinates(60, 75);
		Aeroplane aeroplane = new Aeroplane("Air Force One", planeStart, 20, 0, 1000);

		System.out.println(aeroplane.getName());
		int amountOfStops = 0;

		for(int i = 1; i <= 120; i++) {
			System.out.println("Day " + i + ".");
			System.out.println("Total distance covered by the start of day " + i + ": " + aeroplane.getTotalDistance());

			System.out.println("-------------------------");
			System.out.println("From: " + destination1.getName());
			System.out.println("To: " + destination2.getName());
			aeroplane.singleFlight(destination2.getCoordinates());
			System.out.println("Journey distance: " + aeroplane.getJourneyDistance());
			System.out.println("Total distance covered: " + aeroplane.getTotalDistance());
			System.out.println("-------------------------");

			System.out.println("From: " + destination2.getName());
			System.out.println("To: " + destination3.getName());
			aeroplane.singleFlight(destination3.getCoordinates());
			System.out.println("Journey distance: " + aeroplane.getJourneyDistance());
			System.out.println("Total distance covered: " + aeroplane.getTotalDistance());
			System.out.println("-------------------------");

			System.out.println("From: " + destination3.getName());
			System.out.println("To: " + destination2.getName());
			aeroplane.singleFlight(destination2.getCoordinates());
			System.out.println("Journey distance: " + aeroplane.getJourneyDistance());
			System.out.println("Total distance covered: " + aeroplane.getTotalDistance());
			System.out.println("-------------------------");

			System.out.println("From: " + destination2.getName());
			System.out.println("To: " + destination1.getName());
			aeroplane.singleFlight(destination1.getCoordinates());
			System.out.println("Journey distance: " + aeroplane.getJourneyDistance());
			System.out.println("Total distance covered: " + aeroplane.getTotalDistance());
			System.out.println("-------------------------");

			if(aeroplane.getTotalDistance() >= aeroplane.getRepairDistance()) {
				aeroplane.zeroTotalDistance();
				amountOfStops += 1;
				for(int j = 1; j <= 7; j++) {
					if(i<120){
						i++;
						System.out.println("Day " + i + ", repairs.");
					}
				}
			}
		}
		System.out.println("-------------------------");
		System.out.println("Amount of times that the plane had to undergo repairs: " + amountOfStops);
	}
}