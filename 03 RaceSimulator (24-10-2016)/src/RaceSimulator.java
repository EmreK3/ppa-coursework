public class RaceSimulator {
	public static void main(String[] args) {
		RaceTrack silverstone = new RaceTrack();

		// set track conditions
		silverstone.setAverageLapTime(101);
		silverstone.setIsRaining(false);

		// create 3 cars using the constructor
		Car car1 = new Car(1, 40, 2, 3, 16, 16, 8, 0);
		Car car2 = new Car(2, 35, 4, 5, 22, 14, 9, 0);
		Car car3 = new Car(3, 49, 3, 4, 20, 15, 11, 0);

		// get the cars to complete a lap then determine the race leader
		car1.completeLap(silverstone);
		car2.completeLap(silverstone);
		car3.completeLap(silverstone);
		System.out.println(silverstone.determineRaceLeader(car1, car2, car3));

		// get the cars to complete a lap then determine the race leader		
		car1.completeLap(silverstone);
		car2.completeLap(silverstone);
		car3.completeLap(silverstone);
		System.out.println(silverstone.determineRaceLeader(car1, car2, car3));

		// set isRaining to true, which affects lap times.
		silverstone.setIsRaining(true);

		// get the cars to complete a lap whilst raining then determine the race winner
		car1.completeLap(silverstone);
		car2.completeLap(silverstone);
		car3.completeLap(silverstone);
		System.out.println(silverstone.determineRaceLeader(car1, car2, car3));
	}
}